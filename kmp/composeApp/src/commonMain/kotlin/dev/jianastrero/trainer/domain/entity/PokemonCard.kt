package dev.jianastrero.trainer.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon_card")
data class PokemonCard(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val card: String,
)
