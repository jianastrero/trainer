package dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonOtherSprites(
    @SerialName("official-artwork") val officialArtwork: PokemonOfficialArtworkResponse,
) {
    companion object {
        val Sample = PokemonOtherSprites(
            officialArtwork = PokemonOfficialArtworkResponse.Sample,
        )
    }
}
