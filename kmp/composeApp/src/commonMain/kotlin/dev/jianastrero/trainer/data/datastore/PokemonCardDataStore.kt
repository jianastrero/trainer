package dev.jianastrero.trainer.data.datastore

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import dev.jianastrero.trainer.domain.entity.Pokemon
import dev.jianastrero.trainer.domain.entity.PokemonCard

@Dao
interface PokemonCardDataStore {

    @Insert
    suspend fun insert(pokemonCards: List<PokemonCard>)

    @Query("SELECT * FROM pokemon_card WHERE name = :name LIMIT :limit OFFSET :offset")
    suspend fun get(name: String, offset: Int, limit: Int): List<PokemonCard>

}
