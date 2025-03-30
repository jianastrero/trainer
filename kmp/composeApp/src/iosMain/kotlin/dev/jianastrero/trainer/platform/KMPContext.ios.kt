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

actual fun KMPContext.getString(
    key: String,
    defaultValue: String
): String {
    return runCatching {
        NSUserDefaults.standardUserDefaults.objectForKey(key)
            ?.toString()
            ?: error("Unknown Object")
    }.getOrElse {
        runCatching {
            NSUserDefaults.standardUserDefaults.stringForKey(key) ?: defaultValue
        }.getOrElse {
            defaultValue
        }
    }
}

actual fun KMPContext.getInt(
    key: String,
    defaultValue: Int
): Int {
    return runCatching {
        NSUserDefaults.standardUserDefaults.integerForKey(key).toInt()
    }.getOrElse { defaultValue }
}


actual fun KMPContext.put(
    key: String,
    value: Boolean
) {
    runCatching {
        NSUserDefaults.standardUserDefaults.setBool(value = value, forKey = key)
    }
}

actual fun KMPContext.put(
    key: String,
    value: String
) {
    runCatching {
        NSUserDefaults.standardUserDefaults.setObject(value = value, forKey = key)
    }
}

actual fun KMPContext.put(
    key: String,
    value: Int
) {
    runCatching {
        NSUserDefaults.standardUserDefaults.setInteger(value = value.toLong(), forKey = key)
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
