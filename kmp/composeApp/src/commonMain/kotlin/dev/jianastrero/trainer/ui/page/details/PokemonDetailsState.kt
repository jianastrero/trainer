package dev.jianastrero.trainer.ui.page.details

import dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon.Pokemon
import dev.jianastrero.trainer.domain.model.pokeapi.response.species.PokemonSpecies
import dev.jianastrero.trainer.domain.model.pokemontcg.response.card.PokemonCard

data class PokemonDetailsState(
    val pokemon: Pokemon? = null,
    val pokemonCards: List<PokemonCard> = emptyList(),
    val pokemonSpecies: PokemonSpecies? = null
)
