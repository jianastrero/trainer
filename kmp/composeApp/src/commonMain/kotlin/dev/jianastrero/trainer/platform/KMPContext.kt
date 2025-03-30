package dev.jianastrero.trainer.platform

import okio.Path

expect class KMPContext

expect fun KMPContext.getBoolean(key: String, defaultValue: Boolean): Boolean
expect fun KMPContext.put(key: String, value: Boolean)
expect val KMPContext.cachePath: Path?
