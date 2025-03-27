package dev.jianastrero.trainer.data.usecase

import dev.jianastrero.trainer.domain.model.pokeapi.response.species.PokemonSpecies
import dev.jianastrero.trainer.domain.repository.PokeApiRepository

class GetPokemonSpeciesUseCase(
    private val repository: PokeApiRepository
) {
    suspend operator fun invoke(pokemonId: String): PokemonSpecies? {
        return repository.getSpecies(pokemonId)
    }
}
