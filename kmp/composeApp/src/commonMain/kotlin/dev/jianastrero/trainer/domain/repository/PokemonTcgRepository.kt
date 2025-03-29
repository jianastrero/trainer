package dev.jianastrero.trainer.domain.repository

import dev.jianastrero.trainer.domain.model.NextPokemonCards

interface PokemonTcgRepository {

    suspend fun getPokemonCards(
        name: String,
        page: Int,
        pageSize: Int
    ): NextPokemonCards

}
