package dev.jianastrero.trainer.domain.model.pokemontcg.response.card


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonCardImagesResponse(
    @SerialName("large") val large: String,
    @SerialName("small") val small: String
)
