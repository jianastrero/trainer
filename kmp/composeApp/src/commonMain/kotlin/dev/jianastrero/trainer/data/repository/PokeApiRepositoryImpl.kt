package dev.jianastrero.trainer.data.repository

import dev.jianastrero.trainer.domain.datastore.PokeApiDataStore
import dev.jianastrero.trainer.domain.model.pokeapi.response.PokeApiPaginatedResponse
import dev.jianastrero.trainer.domain.model.pokeapi.response.PokemonItem
import dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon.Pokemon
import dev.jianastrero.trainer.domain.repository.PokeApiRepository

class PokeApiRepositoryImpl(
    private val remote: PokeApiDataStore
) : PokeApiRepository {

    override suspend fun getPokemonList(
        nextPage: PokeApiPaginatedResponse.NextPage
    ): PokeApiPaginatedResponse<PokemonItem> =
        remote.getPokemonList(nextPage)

    override suspend fun getPokemon(id: String): Pokemon =
        remote.getPokemon(id)
}
