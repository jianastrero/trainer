package dev.jianastrero.trainer.domain.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "pokemon_card",
    foreignKeys = [
        ForeignKey(
            entity = Pokemon::class,
            parentColumns = ["id"],
            childColumns = ["pokemonId"],
        )
    ]
)
data class PokemonCard(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val card: String,
    val pokemonId: String,
)
