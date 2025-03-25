package dev.jianastrero.trainer.domain.pokeapi.response.pokemon


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonStatName(
    @SerialName("name") val name: String,
    @SerialName("url") val url: String
)
