package dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonSprites(
    @SerialName("other") val otherSprites: PokemonOtherSprites,
) {
    companion object {
        val Sample = PokemonSprites(
            otherSprites = PokemonOtherSprites.Sample,
        )
    }
}
