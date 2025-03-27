package dev.jianastrero.trainer.domain.ext

import dev.jianastrero.trainer.domain.enumeration.PokemonType
import dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon.Pokemon


val Pokemon?.officialArtwork: String
    get() = this?.sprites?.otherSprites?.officialArtwork?.frontDefault.orEmpty()

val Pokemon?.type: PokemonType
    get() = this?.types?.firstOrNull()?.type?.name ?: PokemonType.Unknown
