package dev.jianastrero.trainer.data.datastore

import dev.jianastrero.trainer.domain.datastore.ConfigDataStore
import dev.jianastrero.trainer.platform.KMPPreference

class ConfigDataStoreLocal(
    private val preference: KMPPreference
) : ConfigDataStore {

    override var isDarkMode: Boolean
        get() = preference.getBoolean(KEY_IS_DARK_MODE, false)
        set(value) {
            preference.put(KEY_IS_DARK_MODE, value)
        }

    companion object {
        private const val KEY_IS_DARK_MODE = "KEY_IS_DARK_MODE"
    }

}
