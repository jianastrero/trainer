package dev.jianastrero.trainer.domain.model.pokeapi.response.species


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonSpeciesHabitatResponse(
    @SerialName("name") val name: String,
    @SerialName("url") val url: String
)
