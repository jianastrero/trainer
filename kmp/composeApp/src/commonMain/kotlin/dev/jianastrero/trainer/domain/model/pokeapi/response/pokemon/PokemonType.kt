package dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonType(
    @SerialName("slot") val slot: Int,
    @SerialName("type") val type: PokemonTypeName
)
