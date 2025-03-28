package dev.jianastrero.trainer.data.remote

import dev.jianastrero.trainer.data.ktor.KtorClient
import dev.jianastrero.trainer.domain.model.pokeapi.response.PokeApiPaginatedResponse
import dev.jianastrero.trainer.domain.model.pokeapi.response.PokemonItemResponse
import dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon.PokemonResponse
import dev.jianastrero.trainer.domain.model.pokeapi.response.species.PokemonSpeciesResponse
import io.ktor.client.call.body
import io.ktor.client.request.get

class PokeApiRemote(
    private val pokeApiClient: KtorClient
) {

    suspend fun getPokemonList(
        offset: Int,
        limit: Int
    ): PokeApiPaginatedResponse<PokemonItemResponse> {
        val response = pokeApiClient.client.get("/api/v2/pokemon?limit=${limit}&offset=${offset}")

        return response.body()
    }

    suspend fun getPokemon(id: String): PokemonResponse {
        val response = pokeApiClient.client.get("/api/v2/pokemon/$id")

        return response.body()
    }

    suspend fun getSpecies(id: String): PokemonSpeciesResponse {
        val response = pokeApiClient.client.get("/api/v2/pokemon-species/$id")

        return response.body()
    }
}
