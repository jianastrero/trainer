package dev.jianastrero.trainer.data.usecase

import dev.jianastrero.trainer.domain.entity.PokemonCard
import dev.jianastrero.trainer.domain.repository.PokemonTcgRepository

class GetNextPokemonCardsUseCase(
    private val repository: PokemonTcgRepository
) {
    private var nextPage: Int = 1
    private var nextPageSize: Int = PAGE_SIZE
    var hasNext: Boolean = true
        private set

    suspend operator fun invoke(name: String): List<PokemonCard> {
        val nextPokemonCards = repository.getPokemonCards(
            name = name,
            page = nextPage,
            pageSize = nextPageSize
        )
        hasNext = nextPokemonCards.hasNext
        nextPage = nextPokemonCards.nextPage
        nextPageSize = nextPokemonCards.nextPageSize

        return nextPokemonCards.pokemonCards
    }

    companion object {
        private const val PAGE_SIZE = 20
    }
}
