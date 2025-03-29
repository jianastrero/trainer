package dev.jianastrero.trainer.ui.page.details

import dev.jianastrero.trainer.domain.entity.Pokemon
import dev.jianastrero.trainer.domain.entity.PokemonCard

data class PokemonDetailsState(
    val pokemon: Pokemon? = null,
    val pokemonCards: List<PokemonCard> = emptyList(),
)
