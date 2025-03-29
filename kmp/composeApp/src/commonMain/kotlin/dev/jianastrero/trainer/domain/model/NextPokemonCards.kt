package dev.jianastrero.trainer.domain.model

import dev.jianastrero.trainer.domain.entity.PokemonCard

data class NextPokemonCards(
    val hasNext: Boolean,
    val nextPage: Int,
    val nextPageSize: Int,
    val pokemonCards: List<PokemonCard>
)
