package dev.jianastrero.trainer.data.repository

import dev.jianastrero.trainer.data.datastore.PokemonDataStore
import dev.jianastrero.trainer.data.remote.PokeApiRemote
import dev.jianastrero.trainer.domain.entity.Pokemon
import dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon.toEntity
import dev.jianastrero.trainer.domain.model.pokeapi.response.species.genus
import dev.jianastrero.trainer.domain.repository.PokeApiRepository

class PokeApiRepositoryImpl(
    private val remote: PokeApiRemote,
    private val dataStore: PokemonDataStore
) : PokeApiRepository {

    override suspend fun getPokemonList(
        offset: Int,
        limit: Int
    ): List<Pokemon> {
        val pokemons = dataStore.get(offset = offset, limit = limit)

        if (pokemons.isNotEmpty()) return pokemons

        val response = remote.getPokemonList(offset = offset, limit = limit)
        val pokemonList = response.results.map { pokemonItem ->
            val pokemonResponse = remote.getPokemon(pokemonItem.id)
            val speciesResponse = remote.getSpecies(pokemonItem.id)
            pokemonResponse.toEntity(
                species = speciesResponse.genus
            )
        }
        dataStore.insert(pokemonList)

        return pokemons
    }

    override suspend fun getPokemon(id: String): Pokemon {
        val pokemon = dataStore.get(id)
        if (pokemon != null) return pokemon

        val speciesResponse = remote.getSpecies(id)
        return remote.getPokemon(id).toEntity(species = speciesResponse.genus)
    }

}
