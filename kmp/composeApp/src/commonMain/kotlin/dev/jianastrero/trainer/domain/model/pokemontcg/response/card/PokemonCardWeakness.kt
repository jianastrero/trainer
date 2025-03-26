package dev.jianastrero.trainer.domain.model.pokemontcg.response.card


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonCardWeakness(
    @SerialName("type") val type: String,
    @SerialName("value") val value: String
)
