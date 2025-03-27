package dev.jianastrero.trainer.data.datastore

import dev.jianastrero.trainer.data.ktor.KtorClient
import dev.jianastrero.trainer.domain.datastore.PokeApiDataStore
import dev.jianastrero.trainer.domain.model.pokeapi.response.PokeApiPaginatedResponse
import dev.jianastrero.trainer.domain.model.pokeapi.response.PokemonItem
import dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon.Pokemon
import dev.jianastrero.trainer.domain.model.pokeapi.response.species.PokemonSpecies
import io.ktor.client.call.body
import io.ktor.client.request.get

class PokeApiDataStoreRemote(
    private val pokeApiClient: KtorClient
) : PokeApiDataStore {

    override suspend fun getPokemonList(
        nextPage: PokeApiPaginatedResponse.NextPage
    ): PokeApiPaginatedResponse<PokemonItem> {
        val response = pokeApiClient.client.get("/api/v2/pokemon?limit=${nextPage.limit}&offset=${nextPage.offset}")

        return response.body()
    }

    override suspend fun getPokemon(id: String): Pokemon {
        val response = pokeApiClient.client.get("/api/v2/pokemon/$id")

        return response.body()
    }

    override suspend fun getSpecies(id: String): PokemonSpecies {
        val response = pokeApiClient.client.get("/api/v2/pokemon-species/$id")

        return response.body()
    }
}
