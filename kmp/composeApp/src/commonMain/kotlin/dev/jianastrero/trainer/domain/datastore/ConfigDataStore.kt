package dev.jianastrero.trainer.domain.datastore

interface ConfigDataStore {
    fun getBoolean(key: String, defaultValue: Boolean): Boolean
    fun putBoolean(key: String, value: Boolean)
}
