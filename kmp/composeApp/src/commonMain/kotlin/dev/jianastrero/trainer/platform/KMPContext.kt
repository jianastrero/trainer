package dev.jianastrero.trainer.platform

expect class KMPContext

expect fun KMPContext.getBoolean(key: String, defaultValue: Boolean): Boolean
expect fun KMPContext.put(key: String, value: Boolean)
