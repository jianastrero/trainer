package dev.jianastrero.trainer.data.repository

import dev.jianastrero.trainer.data.ktor.KtorClient
import dev.jianastrero.trainer.data.service.PokeApiService
import dev.jianastrero.trainer.domain.model.pokeapi.response.PokeApiPaginatedResponse
import dev.jianastrero.trainer.domain.model.pokeapi.response.PokemonItem
import dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon.Pokemon
import dev.jianastrero.trainer.domain.repository.PokeApiRepository

class PokeApiRepositoryImpl(
    private val service: PokeApiService
) : PokeApiRepository {

    override suspend fun getPokemonList(
        nextPage: PokeApiPaginatedResponse.NextPage
    ): PokeApiPaginatedResponse<PokemonItem> =
        service.getPokemonList(nextPage)

    override suspend fun getPokemon(id: String): Pokemon =
        service.getPokemon(id)
}
