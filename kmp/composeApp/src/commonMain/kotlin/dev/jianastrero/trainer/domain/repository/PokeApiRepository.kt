package dev.jianastrero.trainer.domain.repository

import dev.jianastrero.trainer.domain.model.pokeapi.response.PokeApiPaginatedResponse
import dev.jianastrero.trainer.domain.model.pokeapi.response.PokemonItem
import dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon.Pokemon

interface PokeApiRepository {
    suspend fun getPokemonList(
        limit: Int,
        offset: Int
    ): PokeApiPaginatedResponse<PokemonItem>

    suspend fun getPokemon(id: String): Pokemon
}
