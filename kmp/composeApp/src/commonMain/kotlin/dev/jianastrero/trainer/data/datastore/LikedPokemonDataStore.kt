package dev.jianastrero.trainer.data.datastore

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import dev.jianastrero.trainer.domain.entity.LikedPokemon
import dev.jianastrero.trainer.domain.entity.relation.LikedPokemonAndEntity

@Dao
interface LikedPokemonDataStore {

    @Insert
    suspend fun insert(likedPokemon: LikedPokemon)

    @Query("DELETE FROM liked_pokemon WHERE pokemonId = :pokemonId")
    suspend fun delete(pokemonId: String)

    @Query("SELECT EXISTS(SELECT * FROM liked_pokemon WHERE pokemonId = :pokemonId)")
    suspend fun exists(pokemonId: String): Boolean

    @Transaction
    @Query("SELECT * FROM liked_pokemon")
    suspend fun getAll(): List<LikedPokemonAndEntity>

}
