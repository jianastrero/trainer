package dev.jianastrero.trainer.data.usecase

import dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon.Pokemon
import dev.jianastrero.trainer.domain.repository.PokeApiRepository

class GetPokemonUseCase(
    private val repository: PokeApiRepository
) {
    suspend operator fun invoke(pokemonId: String): Pokemon {
        return repository.getPokemon(pokemonId)
    }
}
