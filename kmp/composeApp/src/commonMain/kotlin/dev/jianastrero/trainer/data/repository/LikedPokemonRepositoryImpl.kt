package dev.jianastrero.trainer.data.repository

import dev.jianastrero.trainer.data.datastore.LikedPokemonDataStore
import dev.jianastrero.trainer.domain.entity.LikedPokemon
import dev.jianastrero.trainer.domain.entity.Pokemon
import dev.jianastrero.trainer.domain.repository.LikedPokemonRepository

class LikedPokemonRepositoryImpl(
    private val dataStore: LikedPokemonDataStore
) : LikedPokemonRepository {

    override suspend fun like(pokemonId: String) {
        dataStore.insert(LikedPokemon(pokemonId = pokemonId))
    }

    override suspend fun dislike(pokemonId: String) {
        dataStore.delete(pokemonId)
    }

    override suspend fun isLiked(pokemonId: String): Boolean {
        return dataStore.exists(pokemonId)
    }

    override suspend fun getAll(): List<Pokemon> {
        return dataStore.getAll().map { it.pokemon }
    }

}
