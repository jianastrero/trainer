package dev.jianastrero.trainer.data.datastore

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import dev.jianastrero.trainer.domain.entity.Pokemon

@Dao
interface PokemonDataStore {

    @Insert
    suspend fun insert(pokemonItems: List<Pokemon>)

    @Query("SELECT * FROM pokemon LIMIT :limit OFFSET :offset")
    suspend fun get(
        limit: Int,
        offset: Int
    ): List<Pokemon>

    @Query("SELECT * FROM pokemon WHERE id = :id")
    suspend fun get(id: String): Pokemon?

}
