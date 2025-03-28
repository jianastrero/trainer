package dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon


import dev.jianastrero.trainer.domain.enumeration.PokemonType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonTypeNameResponse(
    @SerialName("name") val name: PokemonType,
)
