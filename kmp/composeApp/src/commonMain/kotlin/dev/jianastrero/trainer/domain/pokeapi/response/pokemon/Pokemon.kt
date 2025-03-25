package dev.jianastrero.trainer.domain.pokeapi.response.pokemon


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pokemon(
    @SerialName("abilities") val abilities: List<PokemonAbility>,
    @SerialName("cries") val cries: PokemonCries,
    @SerialName("height") val height: Int,
    @SerialName("id") val id: Int,
    @SerialName("moves") val moves: List<PokemonMove>,
    @SerialName("name") val name: String,
    @SerialName("species") val species: PokemonSpecies,
    @SerialName("sprites") val sprites: PokemonSprites,
    @SerialName("stats") val stats: List<PokemonStat>,
    @SerialName("types") val types: List<PokemonType>,
    @SerialName("weight") val weight: Int
)
