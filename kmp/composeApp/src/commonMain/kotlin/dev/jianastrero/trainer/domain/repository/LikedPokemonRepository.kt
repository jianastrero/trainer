package dev.jianastrero.trainer.domain.repository

import dev.jianastrero.trainer.domain.entity.Pokemon

interface LikedPokemonRepository {
    suspend fun like(pokemonId: String)
    suspend fun dislike(pokemonId: String)
    suspend fun isLiked(pokemonId: String): Boolean
    suspend fun getAll(): List<Pokemon>
}
