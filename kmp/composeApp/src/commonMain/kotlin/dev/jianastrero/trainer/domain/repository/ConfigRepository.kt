package dev.jianastrero.trainer.domain.repository

import kotlinx.coroutines.flow.StateFlow

interface ConfigRepository {
    val isDarkMode: StateFlow<Boolean>
    var lastSeenPokemonRowId: Int

    fun setDarkMode(isDarkMode: Boolean)
}
