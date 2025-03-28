package dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonCriesResponse(
    @SerialName("latest") val latest: String,
    @SerialName("legacy") val legacy: String
) {
    companion object {
        val Sample = PokemonCriesResponse(
            latest = "latest",
            legacy = "legacy"
        )
    }
}
