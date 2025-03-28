package dev.jianastrero.trainer.domain.model.pokeapi.response.species


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonSpeciesGeneraResponse(
    @SerialName("genus") val genus: String,
    @SerialName("language") val language: PokemonSpeciesLanguageResponse
)
