package dev.jianastrero.trainer.platform

import kotlinx.cinterop.ExperimentalForeignApi
import okio.Path
import okio.Path.Companion.toPath
import platform.Foundation.NSCachesDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDefaults
import platform.Foundation.NSUserDomainMask
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

@OptIn(ExperimentalForeignApi::class)
actual val KMPContext.cachePath: Path?
    get() = runCatching {
        NSFileManager.defaultManager.URLForDirectory(
                directory = NSCachesDirectory,
                inDomain = NSUserDomainMask,
                appropriateForURL = null,
                create = true,
                error = null
            )?.path?.toPath()
    }.getOrNull()
