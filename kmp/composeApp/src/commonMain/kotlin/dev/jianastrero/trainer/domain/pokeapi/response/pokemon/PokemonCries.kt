package dev.jianastrero.trainer.domain.pokeapi.response.pokemon


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonCries(
    @SerialName("latest") val latest: String,
    @SerialName("legacy") val legacy: String
)
