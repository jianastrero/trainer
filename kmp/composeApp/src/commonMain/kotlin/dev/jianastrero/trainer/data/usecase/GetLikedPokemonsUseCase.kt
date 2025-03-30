package dev.jianastrero.trainer.data.usecase

import dev.jianastrero.trainer.domain.entity.Pokemon
import dev.jianastrero.trainer.domain.repository.LikedPokemonRepository

class GetLikedPokemonsUseCase(
    private val repository: LikedPokemonRepository
) {
    suspend operator fun invoke(): List<Pokemon> {
        return repository.getAll()
    }
}
