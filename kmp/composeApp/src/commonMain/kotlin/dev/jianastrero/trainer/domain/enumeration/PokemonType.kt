package dev.jianastrero.trainer.domain.enumeration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class PokemonType {
    @SerialName("normal") Normal,
    @SerialName("fighting") Fighting,
    @SerialName("flying") Flying,
    @SerialName("poison") Poison,
    @SerialName("ground") Ground,
    @SerialName("rock") Rock,
    @SerialName("bug") Bug,
    @SerialName("ghost") Ghost,
    @SerialName("steel") Steel,
    @SerialName("fire") Fire,
    @SerialName("water") Water,
    @SerialName("grass") Grass,
    @SerialName("electric") Electric,
    @SerialName("psychic")Psychic,
    @SerialName("ice") Ice,
    @SerialName("dragon") Dragon,
    @SerialName("dark") Dark,
    @SerialName("fairy") Fairy,
    @SerialName("stellar") Stellar,
    @SerialName("unknown") Unknown,
    @SerialName("shadow") Shadow,
}

