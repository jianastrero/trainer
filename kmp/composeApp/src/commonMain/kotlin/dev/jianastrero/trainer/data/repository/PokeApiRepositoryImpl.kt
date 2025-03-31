package dev.jianastrero.trainer.data.repository

import dev.jianastrero.trainer.data.datastore.PokemonCardDataStore
import dev.jianastrero.trainer.data.datastore.PokemonDataStore
import dev.jianastrero.trainer.data.remote.PokeApiRemote
import dev.jianastrero.trainer.data.remote.PokemonTcgRemote
import dev.jianastrero.trainer.domain.entity.relation.PokemonAndCards
import dev.jianastrero.trainer.domain.model.NextPokemons
import dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon.toEntity
import dev.jianastrero.trainer.domain.model.pokeapi.response.species.genus
import dev.jianastrero.trainer.domain.model.pokemontcg.response.PokemonTcgPaginatedResponse
import dev.jianastrero.trainer.domain.model.pokemontcg.response.card.PokemonCardResponse
import dev.jianastrero.trainer.domain.model.pokemontcg.response.card.toEntity
import dev.jianastrero.trainer.domain.repository.PokeApiRepository

class PokeApiRepositoryImpl(
    private val pokemonRemote: PokeApiRemote,
    private val cardRemote: PokemonTcgRemote,
    private val pokemonDataStore: PokemonDataStore,
    private val cardDataStore: PokemonCardDataStore,
) : PokeApiRepository {

    override suspend fun getNextPokemons(
        offset: Int,
        limit: Int
    ): NextPokemons {
        val localPokemons = pokemonDataStore.getPokemonStartingFromRowId(rowId = offset, limit = limit)

        if (localPokemons.isNotEmpty()) return NextPokemons(
            hasNext = true,
            nextOffset = offset + localPokemons.size,
            pokemons = localPokemons
        )

        return runCatching {
            val response = pokemonRemote.getPokemonList(offset = offset, limit = limit)
            val remotePokemons = response.results.mapNotNull { pokemonItem ->
                runCatching {
                    val pokemonResponse = pokemonRemote.getPokemon(pokemonItem.id)
                    val speciesResponse = pokemonRemote.getSpecies(pokemonItem.id)
                    pokemonResponse.toEntity(
                        species = speciesResponse.genus
                    )
                }.getOrNull()
            }
            pokemonDataStore.insert(remotePokemons)

            NextPokemons(
                hasNext = response.next != null,
                nextOffset = offset + response.results.size,
                pokemons = remotePokemons
            )
        }.onFailure {
            println("JIANDDEBUG -> error: ${it}")
        }.getOrElse {
            NextPokemons(
                hasNext = false,
                nextOffset = offset,
                pokemons = emptyList()
            )
        }
    }

    override suspend fun getPokemon(id: String): PokemonAndCards {
        val localPokemonAndCards = pokemonDataStore.get(id)
        var localPokemon = localPokemonAndCards?.pokemon
        var localCards = localPokemonAndCards?.cards
        if (localPokemon != null && !localCards.isNullOrEmpty()) return PokemonAndCards(
            pokemon = localPokemon,
            cards = localCards
        )

        // if localPokemon is null, fetch from remote
        if (localPokemon == null) {
            val speciesResponse = pokemonRemote.getSpecies(id)
            localPokemon = pokemonRemote.getPokemon(id).toEntity(species = speciesResponse.genus)
            pokemonDataStore.insert(listOf(localPokemon))
        }

        // if localCards is null, fetch from local
        if (localCards.isNullOrEmpty()) {
            val localCards = cardDataStore.get(localPokemon.name, 0, 1000)

            if (localCards.isNotEmpty()) return PokemonAndCards(
                pokemon = localPokemon,
                cards = localCards
            )
        }

        // if localCards is empty, fetch from remote
        if (localCards != null && localCards.isEmpty()) {
            val remoteCards = mutableListOf<PokemonCardResponse>()
            var currentPage = 1
            var result: PokemonTcgPaginatedResponse<PokemonCardResponse>

            do {
                result = cardRemote.getPokemonCards(localPokemon.name, currentPage, 20)
                remoteCards.addAll(result.result)
                currentPage = result.page + 1
            } while (result.result.isNotEmpty())

            localCards = remoteCards
                .map { response ->
                    response.toEntity(
                        pokemonId = localPokemon.id,
                        name = localPokemon.name
                    )
                }
            cardDataStore.insert(localCards)
        }

        return PokemonAndCards(
            pokemon = localPokemon,
            cards = localCards ?: emptyList()
        )
    }

    override suspend fun getPokemonRowId(pokemonId: String): Int =
        pokemonDataStore.getRowId(pokemonId)

}
