package dev.jianastrero.trainer.data.usecase

import dev.jianastrero.trainer.domain.entity.Pokemon
import dev.jianastrero.trainer.domain.repository.PokeApiRepository

class GetPokemonUseCase(
    private val repository: PokeApiRepository
) {
    suspend operator fun invoke(pokemonId: String): Pokemon {
        return repository.getPokemon(pokemonId)
    }
}
