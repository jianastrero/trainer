package dev.jianastrero.trainer.data.repository

import dev.jianastrero.trainer.data.remote.PokemonTcgRemote
import dev.jianastrero.trainer.domain.model.pokemontcg.response.PokemonTcgPaginatedResponse
import dev.jianastrero.trainer.domain.model.pokemontcg.response.card.PokemonCard
import dev.jianastrero.trainer.domain.repository.PokemonTcgRepository

class PokemonTcgRepositoryImpl(
    private val remote: PokemonTcgRemote
) : PokemonTcgRepository {

    override suspend fun getPokemonCards(
        name: String,
        nextPage: PokemonTcgPaginatedResponse.NextPage
    ): PokemonTcgPaginatedResponse<PokemonCard> =
        remote.getPokemonCards(name, nextPage)
}
