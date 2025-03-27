package dev.jianastrero.trainer.domain.datastore

import dev.jianastrero.trainer.domain.model.pokeapi.response.PokeApiPaginatedResponse
import dev.jianastrero.trainer.domain.model.pokeapi.response.PokemonItem
import dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon.Pokemon
import dev.jianastrero.trainer.domain.model.pokeapi.response.species.PokemonSpecies

interface PokeApiDataStore {

    suspend fun getPokemonList(
        nextPage: PokeApiPaginatedResponse.NextPage,
    ): PokeApiPaginatedResponse<PokemonItem>

    suspend fun getPokemon(id: String): Pokemon

    suspend fun getSpecies(id: String): PokemonSpecies

}
