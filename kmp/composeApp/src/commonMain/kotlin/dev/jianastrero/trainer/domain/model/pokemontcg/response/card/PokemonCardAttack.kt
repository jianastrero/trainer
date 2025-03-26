package dev.jianastrero.trainer.domain.model.pokemontcg.response.card


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonCardAttack(
    @SerialName("convertedEnergyCost") val convertedEnergyCost: Int,
    @SerialName("cost") val cost: List<String>,
    @SerialName("damage") val damage: String,
    @SerialName("name") val name: String,
    @SerialName("text") val text: String
)
