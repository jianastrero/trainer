package dev.jianastrero.trainer.platform

import okio.Path

expect class KMPContext

expect fun KMPContext.getBoolean(key: String, defaultValue: Boolean): Boolean
expect fun KMPContext.getString(key: String, defaultValue: String): String
expect fun KMPContext.put(key: String, value: Boolean)
expect fun KMPContext.put(key: String, value: String)
expect val KMPContext.cachePath: Path?
