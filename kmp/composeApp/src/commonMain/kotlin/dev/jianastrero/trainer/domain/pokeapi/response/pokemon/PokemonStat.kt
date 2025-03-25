package dev.jianastrero.trainer.domain.pokeapi.response.pokemon


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonStat(
    @SerialName("base_stat") val baseStat: Int,
    @SerialName("effort") val effort: Int,
    @SerialName("stat") val stat: PokemonStatName
)
