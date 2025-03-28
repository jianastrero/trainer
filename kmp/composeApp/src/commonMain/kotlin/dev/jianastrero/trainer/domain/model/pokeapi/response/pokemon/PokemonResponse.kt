package dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon

import dev.jianastrero.trainer.domain.entity.Pokemon
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonResponse(
    @SerialName("abilities") val abilities: List<PokemonAbilityResponse>,
    @SerialName("cries") val cries: PokemonCriesResponse,
    @SerialName("height") val height: Int,
    @SerialName("id") val id: String,
    @SerialName("moves") val moves: List<PokemonMoveResponse>,
    @SerialName("name") val name: String,
    @SerialName("sprites") val sprites: PokemonSpritesResponse,
    @SerialName("stats") val stats: List<PokemonStatResponse>,
    @SerialName("types") val types: List<PokemonTypeResponse>,
    @SerialName("weight") val weight: Int
) {
    companion object {
        val Sample = PokemonResponse(
            abilities = emptyList(),
            cries = PokemonCriesResponse.Sample,
            height = 0,
            id = "",
            moves = emptyList(),
            name = "Sample",
            sprites = PokemonSpritesResponse.Sample,
            stats = emptyList(),
            types = emptyList(),
            weight = 0
        )
    }

    val heightCm: Float
        get() = height * 10f

    val weightKg: Float
        get() = weight / 10f

    val officialArtwork: String
        get() = sprites.otherSprites.officialArtwork.frontDefault
}

fun PokemonResponse.toEntity(
    species: String
): Pokemon = Pokemon(
    id = id,
    name = name,
    officialArtwork = officialArtwork,
    stats = stats.associate { it.stat.name to it.baseStat },
    types = types.map { it.type.name },
    heightCm = heightCm,
    weightKg = weightKg,
    abilities = abilities.map { it.ability.name },
    species = species,
)
