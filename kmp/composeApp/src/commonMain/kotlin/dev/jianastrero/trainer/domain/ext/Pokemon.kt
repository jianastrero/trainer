package dev.jianastrero.trainer.domain.ext

import dev.jianastrero.trainer.domain.enumeration.PokemonType
import dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon.PokemonResponse


val PokemonResponse?.officialArtwork: String
    get() = this?.sprites?.otherSprites?.officialArtwork?.frontDefault.orEmpty()

val PokemonResponse?.type: PokemonType
    get() = this?.types?.firstOrNull()?.type?.name ?: PokemonType.Unknown
