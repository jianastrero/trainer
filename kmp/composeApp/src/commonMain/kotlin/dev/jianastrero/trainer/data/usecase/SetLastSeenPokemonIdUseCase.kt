package dev.jianastrero.trainer.data.usecase

import dev.jianastrero.trainer.domain.repository.ConfigRepository

class SetLastSeenPokemonIdUseCase(
    private val configRepository: ConfigRepository
) {
    suspend operator fun invoke(pokemonId: String) {
        configRepository.lastSeenPokemonId = pokemonId
    }
}
