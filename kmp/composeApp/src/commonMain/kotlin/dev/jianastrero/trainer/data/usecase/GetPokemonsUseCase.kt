package dev.jianastrero.trainer.data.usecase

import dev.jianastrero.trainer.domain.entity.Pokemon
import dev.jianastrero.trainer.domain.repository.PokeApiRepository

class GetPokemonsUseCase(
    private val repository: PokeApiRepository
) {
    private var nextOffset: Int = 0
    var hasNext = true
        private set

    suspend operator fun invoke(): List<Pokemon> {
        val pokemons = repository.getNextPokemons(offset = nextOffset)
        if (pokemons.isEmpty()) {
            hasNext = false
            return emptyList()
        }

        this.nextOffset += pokemons.size
        return pokemons
    }

}
