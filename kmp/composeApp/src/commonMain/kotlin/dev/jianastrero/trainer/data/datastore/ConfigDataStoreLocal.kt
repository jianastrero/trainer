package dev.jianastrero.trainer.data.datastore

import dev.jianastrero.trainer.domain.datastore.ConfigDataStore
import dev.jianastrero.trainer.platform.KMPPreference

class ConfigDataStoreLocal(
    private val preference: KMPPreference
) : ConfigDataStore {

    override fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return preference.getBoolean(key, defaultValue)
    }

    override fun putBoolean(key: String, value: Boolean) {
        preference.put(key, value)
    }

}
