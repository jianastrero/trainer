package dev.jianastrero.trainer.platform

class KMPPreference(private val kmpContext: KMPContext) {

    fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return kmpContext.getBoolean(key, defaultValue)
    }

    fun put(key: String, value: Boolean) {
        kmpContext.put(key, value)
    }

    fun getString(key: String, defaultValue: String): String? {
        return kmpContext.getString(key, defaultValue)
    }

    fun put(key: String, value: String) {
        kmpContext.put(key, value)
    }

}
