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

    override suspend fun getPokemonCards(
        name: String,
        page: Int,
        pageSize: Int
    ): NextPokemonCards {
        println("JIANDDEBUG -> page: $page, pageSize: $pageSize")

        val localPokemonCards = dataStore.get(name = name)
        if (localPokemonCards.isNotEmpty()) {
            return NextPokemonCards(
                hasNext = true,
                nextPage = 2,
                nextPageSize = pageSize,
                pokemonCards = localPokemonCards,
            )
        }

        val response = remote.getPokemonCards(
            name = name,
            page = page,
            pageSize = pageSize
        )
        val remotePokemonCards = response.result.map { it.toEntity() }
        dataStore.insert(remotePokemonCards)

        return NextPokemonCards(
            hasNext = response.pageSize <= response.count,
            nextPage = page + 1,
            nextPageSize = pageSize,
            pokemonCards = remotePokemonCards,
        )
    }
}
