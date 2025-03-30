package dev.jianastrero.trainer.data.datastore

import dev.jianastrero.trainer.platform.KMPPreference

class ConfigDataStore(
    private val preference: KMPPreference
)  {

    fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return preference.getBoolean(key, defaultValue)
    }

    fun putBoolean(key: String, value: Boolean) {
        preference.put(key, value)
    }

    fun putString(key: String, value: String) {
        preference.put(key, value)
    }

    fun getString(key: String, defaultValue: String): String? {
        return preference.getString(key, defaultValue)
    }

}
