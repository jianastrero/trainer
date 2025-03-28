package dev.jianastrero.trainer.domain.model.pokeapi.response.species


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonSpeciesAreaResponse(
    @SerialName("name") val name: String,
    @SerialName("url") val url: String
)
