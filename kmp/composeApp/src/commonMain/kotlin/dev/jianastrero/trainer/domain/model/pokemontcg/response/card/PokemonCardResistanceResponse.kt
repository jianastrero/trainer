package dev.jianastrero.trainer.domain.model.pokemontcg.response.card


import dev.jianastrero.trainer.domain.enumeration.PokemonType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonCardResistanceResponse(
    @SerialName("type") val type: PokemonType,
    @SerialName("value") val value: String
)
