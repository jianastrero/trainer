package dev.jianastrero.trainer.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.jianastrero.trainer.domain.enumeration.PokemonStat
import dev.jianastrero.trainer.domain.enumeration.PokemonType

@Entity(tableName = "pokemon")
data class Pokemon(
    @PrimaryKey val id: String,
    val name: String,
    val officialArtwork: String,
    val stats: Map<PokemonStat, Int>,
    val types: List<PokemonType>,
    val heightCm: Float,
    val weightKg: Float,
    val species: String,
    val abilities: List<String>,
)

val Pokemon.primaryType: PokemonType?
    get() = types.firstOrNull()
