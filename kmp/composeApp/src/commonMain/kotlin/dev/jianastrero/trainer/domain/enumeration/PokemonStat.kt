package dev.jianastrero.trainer.domain.enumeration

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@OptIn(ExperimentalSerializationApi::class)
@Serializable
enum class PokemonStat(val label: String) {
    @JsonNames("hp", "HP") HP("HP"),
    @JsonNames("attack", "Attack") Attack("Attack"),
    @JsonNames("defense", "Defense") Defense("Defense"),
    @JsonNames("special-attack", "SpecialAttack") SpecialAttack("Special Attack"),
    @JsonNames("special-defense", "SpecialDefense") SpecialDefense("Special Defense"),
    @JsonNames("speed", "Speed") Speed("Speed");

    companion object {
        val labels = arrayOf(
            HP,
            Attack,
            Defense,
            SpecialAttack,
            SpecialDefense,
            Speed
        )
    }
}
