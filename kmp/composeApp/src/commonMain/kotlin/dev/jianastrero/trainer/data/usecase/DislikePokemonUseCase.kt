package dev.jianastrero.trainer.data.usecase

import dev.jianastrero.trainer.domain.repository.LikedPokemonRepository

class DislikePokemonUseCase(
    private val repository: LikedPokemonRepository,
) {
    suspend operator fun invoke(pokemonId: String) {
        repository.dislike(pokemonId)
    }
}
