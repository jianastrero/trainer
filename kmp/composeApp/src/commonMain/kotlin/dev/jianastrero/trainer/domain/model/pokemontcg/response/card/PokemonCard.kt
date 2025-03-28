package dev.jianastrero.trainer.domain.model.pokemontcg.response.card


import dev.jianastrero.trainer.domain.enumeration.PokemonType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonCard(
    @SerialName("artist") val artist: String = "",
    @SerialName("attacks") val pokemonCardAttacks: List<PokemonCardAttack> = emptyList(),
    @SerialName("hp") val hp: String = "",
    @SerialName("id") val id: String = "",
    @SerialName("images") val images: PokemonCardImages,
    @SerialName("name") val name: String = "",
    @SerialName("nationalPokedexNumbers") val nationalPokedexNumbers: List<Int> = emptyList(),
    @SerialName("number") val number: String = "",
    @SerialName("rarity") val rarity: String = "",
    @SerialName("resistances") val resistances: List<PokemonCardResistance> = emptyList(),
    @SerialName("types") val types: List<PokemonType> = emptyList(),
    @SerialName("weaknesses") val weaknesses: List<PokemonCardWeakness> = emptyList()
)
