package dev.jianastrero.trainer.domain.model.pokeapi.response.species


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonSpeciesLanguage(
    @SerialName("name") val name: String,
    @SerialName("url") val url: String
)
