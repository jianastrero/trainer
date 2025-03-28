package dev.jianastrero.trainer.domain.repository

import dev.jianastrero.trainer.domain.entity.Pokemon

interface PokeApiRepository {

    suspend fun getPokemonList(
        offset: Int,
        limit: Int = 5
    ): List<Pokemon>

    suspend fun getPokemon(id: String): Pokemon
}
