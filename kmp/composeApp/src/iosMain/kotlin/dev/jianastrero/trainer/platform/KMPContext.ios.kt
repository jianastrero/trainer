package dev.jianastrero.trainer.platform

import okio.Path
import platform.Foundation.NSUserDefaults
import platform.darwin.NSObject

actual typealias KMPContext = NSObject

actual fun KMPContext.getBoolean(
    key: String,
    defaultValue: Boolean
): Boolean = runCatching {
    NSUserDefaults.standardUserDefaults.boolForKey(key)
}.getOrElse { defaultValue }

actual fun KMPContext.put(
    key: String,
    value: Boolean
) {
    runCatching {
        NSUserDefaults.standardUserDefaults.setBool(value = value, forKey = key)
    }
}

actual val KMPContext.cachePath: Path?
    get() = TODO("Not yet implemented")
