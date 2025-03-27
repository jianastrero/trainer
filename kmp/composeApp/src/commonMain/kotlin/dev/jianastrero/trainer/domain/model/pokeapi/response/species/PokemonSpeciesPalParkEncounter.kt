package dev.jianastrero.trainer.domain.model.pokeapi.response.species


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonSpeciesPalParkEncounter(
    @SerialName("area") val area: PokemonSpeciesArea,
    @SerialName("base_score") val baseScore: Int,
    @SerialName("rate") val rate: Int
)
