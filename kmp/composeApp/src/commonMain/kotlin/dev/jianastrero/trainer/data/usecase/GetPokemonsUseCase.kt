package dev.jianastrero.trainer.data.usecase

import dev.jianastrero.trainer.domain.model.pokeapi.response.PokeApiPaginatedResponse
import dev.jianastrero.trainer.domain.model.pokeapi.response.PokemonItem
import dev.jianastrero.trainer.domain.repository.PokeApiRepository

class GetPokemonsUseCase(
    private val repository: PokeApiRepository
) {
    private var nextPage = startingPage

    suspend operator fun invoke(): PokeApiPaginatedResponse<PokemonItem> {
        val response = repository.getPokemonList(nextPage)
        nextPage = response.nextPage ?: startingPage
        return response
    }

    fun reset() {
        nextPage = startingPage
    }

    companion object {
        private val startingPage = PokeApiPaginatedResponse.NextPage(0, 20)
    }
}
