package dev.jianastrero.trainer.data.repository

import dev.jianastrero.trainer.data.datastore.PokemonCardDataStore
import dev.jianastrero.trainer.data.remote.PokemonTcgRemote
import dev.jianastrero.trainer.domain.model.NextPokemonCards
import dev.jianastrero.trainer.domain.model.pokemontcg.response.card.toEntity
import dev.jianastrero.trainer.domain.repository.PokemonTcgRepository

class PokemonTcgRepositoryImpl(
    private val remote: PokemonTcgRemote,
    private val dataStore: PokemonCardDataStore
) : PokemonTcgRepository {

    override suspend fun getNextPokemonCards(
        name: String,
        page: Int,
        pageSize: Int
    ): NextPokemonCards {

        val localPokemonCards = dataStore.get(
            name = name,
            offset = page * pageSize,
            limit = pageSize
        )
        if (localPokemonCards.isNotEmpty()) {
            return NextPokemonCards(
                hasNext = true,
                nextPage = page + 1,
                nextPageSize = pageSize,
                pokemonCards = localPokemonCards,
            )
        }

        return runCatching {
            val response = remote.getPokemonCards(
                name = name,
                page = page,
                pageSize = pageSize
            )
            val remotePokemonCards = response.result.map { it.toEntity(name) }
            dataStore.insert(remotePokemonCards)

            NextPokemonCards(
                hasNext = response.pageSize <= response.count,
                nextPage = page + 1,
                nextPageSize = pageSize,
                pokemonCards = remotePokemonCards,
            )
        }.getOrElse {
            NextPokemonCards(
                hasNext = false,
                nextPage = page,
                nextPageSize = pageSize,
                pokemonCards = emptyList(),
            )
        }
    }
}
