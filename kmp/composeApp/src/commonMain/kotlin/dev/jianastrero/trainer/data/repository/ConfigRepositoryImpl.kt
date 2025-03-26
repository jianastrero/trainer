package dev.jianastrero.trainer.data.repository

import dev.jianastrero.trainer.domain.datastore.ConfigDataStore
import dev.jianastrero.trainer.domain.repository.ConfigRepository

class ConfigRepositoryImpl(
    private val dataStore: ConfigDataStore
) : ConfigRepository {

    override var isDarkMode: Boolean
        get() = dataStore.getBoolean(KEY_IS_DARK_MODE, false)
        set(value) {
            dataStore.putBoolean(KEY_IS_DARK_MODE, value)
        }

    companion object {
        private const val KEY_IS_DARK_MODE = "KEY_IS_DARK_MODE"
    }
}
