package dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon


import dev.jianastrero.trainer.domain.enumeration.PokemonStat
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonStatName(
    @SerialName("name") val name: PokemonStat,
    @SerialName("url") val url: String
)
