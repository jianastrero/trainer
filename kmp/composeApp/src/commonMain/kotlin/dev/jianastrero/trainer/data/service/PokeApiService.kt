package dev.jianastrero.trainer.data.service

import dev.jianastrero.trainer.data.ktor.KtorClient
import dev.jianastrero.trainer.domain.model.pokeapi.response.PokeApiPaginatedResponse
import dev.jianastrero.trainer.domain.model.pokeapi.response.PokemonItem
import dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon.Pokemon
import io.ktor.client.call.body
import io.ktor.client.request.get

class PokeApiService(
    private val pokeApiClient: KtorClient
) {

    suspend fun getPokemonList(
        nextPage: PokeApiPaginatedResponse.NextPage,
    ): PokeApiPaginatedResponse<PokemonItem> {
        val response = pokeApiClient.client.get("pokemon?limit=${nextPage.limit}&offset=${nextPage.offset}")

        return response.body()
    }

    suspend fun getPokemon(id: String): Pokemon {
        val response = pokeApiClient.client.get("pokemon/$id")

        return response.body()
    }

}
