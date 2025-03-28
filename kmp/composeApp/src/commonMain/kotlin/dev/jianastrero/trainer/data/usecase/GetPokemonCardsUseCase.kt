package dev.jianastrero.trainer.data.usecase

import dev.jianastrero.trainer.domain.model.pokemontcg.response.PokemonTcgPaginatedResponse
import dev.jianastrero.trainer.domain.model.pokemontcg.response.card.PokemonCard
import dev.jianastrero.trainer.domain.repository.PokemonTcgRepository

class GetPokemonCardsUseCase(
    private val repository: PokemonTcgRepository
) {
    private var nextPage: PokemonTcgPaginatedResponse.NextPage? = startingPage

    suspend operator fun invoke(name: String): List<PokemonCard> {
        val nextPage = nextPage
        if (nextPage == null) return emptyList()

        val response = repository.getPokemonCards(name, nextPage)
        this.nextPage = response.nextPage
        return response.result
    }

    fun hasNext(): Boolean = nextPage != null

    fun reset() {
        nextPage = startingPage
    }

    companion object {
        private val startingPage = PokemonTcgPaginatedResponse.NextPage(1, 20)
    }

}
