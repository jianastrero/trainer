package dev.jianastrero.trainer.domain.pokeapi.response.pokemon


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonSprites(
    @SerialName("other") val otherSprites: PokemonOtherSprites,
)
