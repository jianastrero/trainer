package dev.jianastrero.trainer.domain.datastore

interface ConfigDataStore {
    fun getBoolean(key: String, defaultValue: Boolean): Boolean
    fun putBoolean(key: String, value: Boolean)
    fun putString(key: String, value: String)
    fun getString(key: String, defaultValue: String): String
    fun putInt(key: String, value: Int)
    fun getInt(key: String, defaultValue: Int): Int
}
