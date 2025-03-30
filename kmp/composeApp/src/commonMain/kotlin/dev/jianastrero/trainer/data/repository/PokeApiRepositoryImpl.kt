package dev.jianastrero.trainer.data.repository

import dev.jianastrero.trainer.data.datastore.PokemonDataStore
import dev.jianastrero.trainer.data.remote.PokeApiRemote
import dev.jianastrero.trainer.domain.entity.Pokemon
import dev.jianastrero.trainer.domain.model.NextPokemons
import dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon.toEntity
import dev.jianastrero.trainer.domain.model.pokeapi.response.species.genus
import dev.jianastrero.trainer.domain.repository.PokeApiRepository

class PokeApiRepositoryImpl(
    private val remote: PokeApiRemote,
    private val dataStore: PokemonDataStore
) : PokeApiRepository {

    override suspend fun getNextPokemons(
        offset: Int,
        limit: Int
    ): NextPokemons {
        val localPokemons = dataStore.get(offset = offset, limit = limit)

        if (localPokemons.isNotEmpty()) return NextPokemons(
            hasNext = true,
            nextOffset = offset + localPokemons.size,
            pokemons = localPokemons
        )

        return runCatching {
            val response = remote.getPokemonList(offset = offset, limit = limit)
            val remotePokemons = response.results.map { pokemonItem ->
                val pokemonResponse = remote.getPokemon(pokemonItem.id)
                val speciesResponse = remote.getSpecies(pokemonItem.id)
                pokemonResponse.toEntity(
                    species = speciesResponse.genus
                )
            }
            dataStore.insert(remotePokemons)

            NextPokemons(
                hasNext = response.next != null,
                nextOffset = offset + response.results.size,
                pokemons = remotePokemons
            )
        }.getOrElse {
            NextPokemons(
                hasNext = false,
                nextOffset = offset,
                pokemons = emptyList()
            )
        }
    }

    override suspend fun getPokemon(id: String): Pokemon {
        val pokemon = dataStore.get(id)
        if (pokemon != null) return pokemon

        val speciesResponse = remote.getSpecies(id)
        return remote.getPokemon(id).toEntity(species = speciesResponse.genus)
    }

}
