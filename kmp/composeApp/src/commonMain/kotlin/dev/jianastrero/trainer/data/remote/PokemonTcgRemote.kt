package dev.jianastrero.trainer.data.remote

import dev.jianastrero.trainer.data.ktor.KtorClient
import dev.jianastrero.trainer.domain.model.pokemontcg.response.PokemonTcgPaginatedResponse
import dev.jianastrero.trainer.domain.model.pokemontcg.response.card.PokemonCard
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.headers

class PokemonTcgRemote(
    private val ktorClient: KtorClient
) {

    suspend fun getPokemonCards(
        name: String,
        nextPage: PokemonTcgPaginatedResponse.NextPage
    ): PokemonTcgPaginatedResponse<PokemonCard> {
        val response = ktorClient.client.get(
            "/v2/cards?q=name:$name&page=${nextPage.page}&pageSize=${nextPage.pageSize}"
        ) {
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
