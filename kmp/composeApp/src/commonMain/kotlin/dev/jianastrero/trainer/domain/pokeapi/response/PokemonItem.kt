package dev.jianastrero.trainer.domain.pokeapi.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonItem(
    @SerialName("name") val name: String,
    @SerialName("url") val url: String
) {
    val id: Int
        get() = url.split("/").last { it.isNotEmpty() }.toIntOrNull() ?: 1

    val imageUrl: String
        get() = "$POKEMON_OFFICIAL_ARTWORK_BASE_URL/$id.$POKEMON_OFFICIAL_ARTWORK_EXTENSION"

    companion object {
        private const val POKEMON_OFFICIAL_ARTWORK_BASE_URL =
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork"
        private const val POKEMON_OFFICIAL_ARTWORK_EXTENSION = "png"
    }
}
