package dev.jianastrero.trainer.domain.repository

import dev.jianastrero.trainer.domain.entity.relation.PokemonAndCards
import dev.jianastrero.trainer.domain.model.NextPokemons

interface PokeApiRepository {

    suspend fun getNextPokemons(
        offset: Int,
        limit: Int
    ): NextPokemons

    suspend fun getPokemon(id: String): PokemonAndCards
}
