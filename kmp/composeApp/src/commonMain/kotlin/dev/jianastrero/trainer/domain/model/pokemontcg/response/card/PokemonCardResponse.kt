package dev.jianastrero.trainer.domain.model.pokemontcg.response.card


import dev.jianastrero.trainer.domain.entity.PokemonCard
import dev.jianastrero.trainer.domain.enumeration.PokemonType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonCardResponse(
    @SerialName("artist") val artist: String = "",
    @SerialName("attacks") val pokemonCardAttacks: List<PokemonCardAttackResponse> = emptyList(),
    @SerialName("hp") val hp: String = "",
    @SerialName("id") val id: String = "",
    @SerialName("images") val images: PokemonCardImagesResponse,
    @SerialName("name") val name: String = "",
    @SerialName("nationalPokedexNumbers") val nationalPokedexNumbers: List<Int> = emptyList(),
    @SerialName("number") val number: String = "",
    @SerialName("rarity") val rarity: String = "",
    @SerialName("resistances") val resistances: List<PokemonCardResistanceResponse> = emptyList(),
    @SerialName("types") val types: List<PokemonType> = emptyList(),
    @SerialName("weaknesses") val weaknesses: List<PokemonCardWeaknessResponse> = emptyList()
)

fun PokemonCardResponse.toEntity(): PokemonCard = PokemonCard(
    name = name,
    card = images.small
)
