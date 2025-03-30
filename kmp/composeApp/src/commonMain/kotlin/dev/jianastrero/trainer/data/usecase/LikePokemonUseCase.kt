package dev.jianastrero.trainer.data.usecase

import dev.jianastrero.trainer.domain.repository.LikedPokemonRepository

class LikePokemonUseCase(
    private val repository: LikedPokemonRepository,
) {
    suspend operator fun invoke(pokemonId: String) {
        repository.like(pokemonId)
    }
}
