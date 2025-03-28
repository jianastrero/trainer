package dev.jianastrero.trainer.data.usecase

import dev.jianastrero.trainer.domain.model.pokeapi.response.PokeApiPaginatedResponse
import dev.jianastrero.trainer.domain.model.pokeapi.response.PokemonItem
import dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon.Pokemon
import dev.jianastrero.trainer.domain.repository.PokeApiRepository

class GetPokemonsUseCase(
    private val repository: PokeApiRepository
) {
    private var nextPage: PokeApiPaginatedResponse.NextPage? = startingPage

    suspend operator fun invoke(): List<Pokemon> {
        val nextPage = nextPage
        if (nextPage == null) return emptyList()

        val response = repository.getPokemonList(nextPage)
        this.nextPage = response.nextPage
        return response.results.map { repository.getPokemon(it.id) }
    }

    fun hasNext(): Boolean = nextPage != null

    fun reset() {
        nextPage = startingPage
    }

    companion object {
        private val startingPage = PokeApiPaginatedResponse.NextPage(0, 5)
    }
}
