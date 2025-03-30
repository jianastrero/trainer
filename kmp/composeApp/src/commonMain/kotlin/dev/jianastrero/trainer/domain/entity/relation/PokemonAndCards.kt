package dev.jianastrero.trainer.domain.entity.relation

import androidx.room.Embedded
import androidx.room.Relation
import dev.jianastrero.trainer.domain.entity.Pokemon
import dev.jianastrero.trainer.domain.entity.PokemonCard

data class PokemonAndCards(
    @Embedded val pokemon: Pokemon,
    @Relation(
        parentColumn = "id",
        entityColumn = "pokemonId",
    )
    val cards: List<PokemonCard>
)
