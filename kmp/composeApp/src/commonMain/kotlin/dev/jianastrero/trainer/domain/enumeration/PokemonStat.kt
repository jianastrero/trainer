package dev.jianastrero.trainer.domain.enumeration

import kotlinx.serialization.SerialName

enum class PokemonStat(val label: String) {
    @SerialName("hp") HP("HP"),
    @SerialName("attack") Attack("Attack"),
    @SerialName("defense") Defense("Defense"),
    @SerialName("special-attack") SpecialAttack("Special Attack"),
    @SerialName("special-defense") SpecialDefense("Special Defense"),
    @SerialName("speed") Speed("Speed");

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
