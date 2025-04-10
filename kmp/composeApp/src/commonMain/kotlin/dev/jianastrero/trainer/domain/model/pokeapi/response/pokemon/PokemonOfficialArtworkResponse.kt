package dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonOfficialArtworkResponse(
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_shiny") val frontShiny: String
) {
    companion object {
        val Sample = PokemonOfficialArtworkResponse(
            frontDefault = "frontDefault",
            frontShiny = "frontShiny"
        )
    }
}
