package dev.jianastrero.trainer.data.datastore

import dev.jianastrero.trainer.domain.datastore.ConfigDataStore
import dev.jianastrero.trainer.platform.KMPPreference

class ConfigDataStoreImpl(
    private val preference: KMPPreference
) : ConfigDataStore {

    override fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return preference.getBoolean(key, defaultValue)
    }

    override fun putBoolean(key: String, value: Boolean) {
        preference.put(key, value)
    }

    override fun putString(key: String, value: String) {
        preference.put(key, value)
    }

    override fun getString(key: String, defaultValue: String): String {
        return preference.getString(key, defaultValue)
    }

    override fun putInt(key: String, value: Int) {
        preference.put(key, value)
    }

    override fun getInt(key: String, defaultValue: Int): Int {
        return preference.getInt(key, defaultValue)
    }

}
