package dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonSpecies(
    @SerialName("name") val name: String,
    @SerialName("url") val url: String
) {
    companion object {
        val Sample = PokemonSpecies(
            name = "name",
            url = "url"
        )
    }
}
