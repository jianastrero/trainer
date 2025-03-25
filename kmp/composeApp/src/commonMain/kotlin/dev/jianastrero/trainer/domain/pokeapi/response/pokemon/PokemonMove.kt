package dev.jianastrero.trainer.domain.pokeapi.response.pokemon


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonMove(
    @SerialName("move") val move: PokemonMoveName,
)
