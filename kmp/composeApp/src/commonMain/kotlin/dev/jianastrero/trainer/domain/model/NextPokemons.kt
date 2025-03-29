package dev.jianastrero.trainer.domain.model

import dev.jianastrero.trainer.domain.entity.Pokemon

data class NextPokemons(
    val hasNext: Boolean,
    val nextOffset: Int,
    val pokemons: List<Pokemon>
)
