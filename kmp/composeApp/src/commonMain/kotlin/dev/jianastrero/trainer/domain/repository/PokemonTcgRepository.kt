package dev.jianastrero.trainer.domain.repository

import dev.jianastrero.trainer.domain.model.pokemontcg.response.PokemonTcgPaginatedResponse
import dev.jianastrero.trainer.domain.model.pokemontcg.response.card.PokemonCard

interface PokemonTcgRepository {

    suspend fun getPokemonCards(
        name: String,
        nextPage: PokemonTcgPaginatedResponse.NextPage
    ): PokemonTcgPaginatedResponse<PokemonCard>

}
