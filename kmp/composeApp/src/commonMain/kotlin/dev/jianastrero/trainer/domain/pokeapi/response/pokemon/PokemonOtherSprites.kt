package dev.jianastrero.trainer.domain.pokeapi.response.pokemon


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonOtherSprites(
    @SerialName("official-artwork") val officialArtwork: PokemonOfficialArtwork,
)
