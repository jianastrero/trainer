package dev.jianastrero.trainer.domain.repository

import kotlinx.coroutines.flow.StateFlow

interface ConfigRepository {
    val isDarkMode: StateFlow<Boolean>
    var lastSeenPokemonId: String

    fun setDarkMode(isDarkMode: Boolean)
}
