package dev.jianastrero.trainer.domain.entity.relation

import androidx.room.Embedded
import androidx.room.Relation
import dev.jianastrero.trainer.domain.entity.LikedPokemon
import dev.jianastrero.trainer.domain.entity.Pokemon

data class LikedPokemonAndEntity(
    @Embedded val likedPokemon: LikedPokemon,
    @Relation(
        parentColumn = "pokemonId",
        entityColumn = "id",
    )
    val pokemon: Pokemon
)
