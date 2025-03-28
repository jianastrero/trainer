package dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonMoveResponse(
    @SerialName("move") val move: PokemonMoveNameResponse,
)
