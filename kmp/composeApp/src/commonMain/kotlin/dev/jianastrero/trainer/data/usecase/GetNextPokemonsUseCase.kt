package dev.jianastrero.trainer.data.usecase

import dev.jianastrero.trainer.domain.entity.Pokemon
import dev.jianastrero.trainer.domain.repository.PokeApiRepository

class GetNextPokemonsUseCase(
    private val repository: PokeApiRepository
) {
    private var nextOffset: Int = 0
    var hasNext = true
        private set

    suspend operator fun invoke(): List<Pokemon> {
        val nextPokemons = repository.getNextPokemons(
            offset = nextOffset,
            limit = if (nextOffset == 0) 2 else 1
        )
        hasNext = nextPokemons.hasNext
        nextOffset = nextPokemons.nextOffset

        return nextPokemons.pokemons
    }

}
