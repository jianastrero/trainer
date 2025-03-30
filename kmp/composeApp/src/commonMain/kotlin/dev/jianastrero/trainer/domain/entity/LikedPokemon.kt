package dev.jianastrero.trainer.domain.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "liked_pokemon",
    foreignKeys = [
        ForeignKey(
            entity = Pokemon::class,
            parentColumns = ["id"],
            childColumns = ["pokemonId"],
        )
    ]
)
data class LikedPokemon(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val pokemonId: String
)
