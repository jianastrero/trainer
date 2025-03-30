package dev.jianastrero.trainer.data.usecase

import dev.jianastrero.trainer.domain.entity.relation.PokemonAndCards
import dev.jianastrero.trainer.domain.repository.PokeApiRepository

class GetPokemonUseCase(
    private val repository: PokeApiRepository
) {
    suspend operator fun invoke(pokemonId: String): PokemonAndCards {
        return repository.getPokemon(pokemonId)
    }
}
