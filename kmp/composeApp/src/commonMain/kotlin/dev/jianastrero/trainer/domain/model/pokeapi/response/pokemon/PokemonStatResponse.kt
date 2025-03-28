package dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonStatResponse(
    @SerialName("base_stat") val baseStat: Int,
    @SerialName("effort") val effort: Int,
    @SerialName("stat") val stat: PokemonStatNameResponse
)
