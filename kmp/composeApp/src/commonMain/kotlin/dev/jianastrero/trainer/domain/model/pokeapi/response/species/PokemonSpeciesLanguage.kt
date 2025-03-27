package dev.jianastrero.trainer.domain.model.pokeapi.response.species


import dev.jianastrero.trainer.domain.enumeration.Language
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonSpeciesLanguage(
    @SerialName("name") val name: Language?,
    @SerialName("url") val url: String
)
