package dev.jianastrero.trainer.domain.pokeapi.response.pokemon


import dev.jianastrero.trainer.domain.enumeration.PokemonType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonTypeName(
    @SerialName("name") val name: PokemonType,
)
