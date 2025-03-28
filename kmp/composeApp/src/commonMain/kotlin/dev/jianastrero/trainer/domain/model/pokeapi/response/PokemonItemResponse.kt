package dev.jianastrero.trainer.domain.model.pokeapi.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonItemResponse(
    @SerialName("name") val name: String,
    @SerialName("url") val url: String
) {
    val id: String
        get() = url.split("/").last { it.isNotEmpty() }

    val imageUrl: String
        get() = "$POKEMON_OFFICIAL_ARTWORK_BASE_URL/$id.$POKEMON_OFFICIAL_ARTWORK_EXTENSION"

    companion object {
        private const val POKEMON_OFFICIAL_ARTWORK_BASE_URL =
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork"
        private const val POKEMON_OFFICIAL_ARTWORK_EXTENSION = "png"
    }
}
