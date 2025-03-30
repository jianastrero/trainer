package dev.jianastrero.trainer.data.datastore

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import dev.jianastrero.trainer.domain.entity.Pokemon
import dev.jianastrero.trainer.domain.entity.relation.PokemonAndCards

@Dao
interface PokemonDataStore {

    @Insert
    suspend fun insert(pokemonItems: List<Pokemon>)

    @Query("SELECT * FROM pokemon LIMIT :limit OFFSET :offset")
    suspend fun get(
        limit: Int,
        offset: Int
    ): List<Pokemon>

    @Transaction
    @Query("SELECT * FROM pokemon WHERE id = :id LIMIT 1")
    suspend fun get(id: String): PokemonAndCards?

    @Query("SELECT rowid FROM pokemon WHERE id = :id LIMIT 1")
    suspend fun getRowId(id: String): Int

    @Transaction
    @Query("SELECT * FROM pokemon WHERE rowid >= :rowId LIMIT :limit")
    suspend fun getPokemonStartingFromRowId(
        rowId: Int,
        limit: Int
    ): List<Pokemon>

}
