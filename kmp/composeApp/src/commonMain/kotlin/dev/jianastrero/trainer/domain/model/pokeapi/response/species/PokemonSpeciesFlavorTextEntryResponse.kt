package dev.jianastrero.trainer.domain.model.pokeapi.response.species


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonSpeciesFlavorTextEntryResponse(
    @SerialName("flavor_text") val flavorText: String,
    @SerialName("language") val language: PokemonSpeciesLanguageResponse,
    @SerialName("version") val version: PokemonSpeciesVersionResponse
)
