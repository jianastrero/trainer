package dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonAbilityResponse(
    @SerialName("ability") val ability: PokemonAbilityNameResponse,
    @SerialName("is_hidden") val isHidden: Boolean,
    @SerialName("slot") val slot: Int
)
