package dev.jianastrero.trainer.data.usecase

import dev.jianastrero.trainer.domain.repository.ConfigRepository
import dev.jianastrero.trainer.domain.repository.PokeApiRepository

class SetLastSeenPokemonIdUseCase(
    private val pokeApiRepository: PokeApiRepository,
    private val configRepository: ConfigRepository
) {
    suspend operator fun invoke(pokemonId: String) {
        configRepository.lastSeenPokemonRowId = pokeApiRepository.getPokemonRowId(pokemonId)
    }
}
