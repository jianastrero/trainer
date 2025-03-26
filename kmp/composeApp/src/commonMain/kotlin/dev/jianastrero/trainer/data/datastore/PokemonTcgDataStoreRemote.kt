package dev.jianastrero.trainer.data.datastore

import dev.jianastrero.trainer.data.ktor.KtorClient
import dev.jianastrero.trainer.domain.datastore.PokemonTcgDataStore
import dev.jianastrero.trainer.domain.model.pokemontcg.response.PokemonTcgPaginatedResponse
import dev.jianastrero.trainer.domain.model.pokemontcg.response.card.PokemonCard
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.headers

class PokemonTcgDataStoreRemote(
    private val ktorClient: KtorClient
) : PokemonTcgDataStore {

    override suspend fun getPokemonDetails(name: String): PokemonTcgPaginatedResponse<PokemonCard> {
        val response = ktorClient.client.get("v2/cards?name=$name") {
            headers {
                append("X-Api-Key", API_KEY)
            }
        }

        return response.body()
    }

    companion object {
        private const val API_KEY = "b964b7aa-b5f1-4260-a86c-da54d1d6dafc"
    }
}
