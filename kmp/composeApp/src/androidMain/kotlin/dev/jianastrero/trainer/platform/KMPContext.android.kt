package dev.jianastrero.trainer.platform

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.core.content.edit
import okio.Path
import okio.Path.Companion.toOkioPath

actual typealias KMPContext = Application

actual fun KMPContext.getBoolean(
    key: String,
    defaultValue: Boolean
): Boolean {
    if (sharedPreferences == null) initSharedPreferences()

    return runCatching {
        sharedPreferences?.getBoolean(key, defaultValue) ?: defaultValue
    }.getOrElse { defaultValue }
}

actual fun KMPContext.getString(
    key: String,
    defaultValue: String
): String {
    if (sharedPreferences == null) initSharedPreferences()

    return runCatching {
        sharedPreferences?.getString(key, defaultValue) ?: defaultValue
    }.getOrElse { defaultValue }
}

actual fun KMPContext.getInt(
    key: String,
    defaultValue: Int
): Int {
    if (sharedPreferences == null) initSharedPreferences()

    return runCatching {
        sharedPreferences?.getInt(key, defaultValue) ?: defaultValue
    }.getOrElse { defaultValue }
}

actual fun KMPContext.put(
    key: String,
    value: Boolean
) {
    if (sharedPreferences == null) initSharedPreferences()

    runCatching {
        sharedPreferences?.edit {
            putBoolean(key, value)
        }
    }
}

actual fun KMPContext.put(
    key: String,
    value: String
) {
    if (sharedPreferences == null) initSharedPreferences()

    runCatching {
        sharedPreferences?.edit {
            putString(key, value)
        }
    }
}

actual fun KMPContext.put(
    key: String,
    value: Int
) {
    if (sharedPreferences == null) initSharedPreferences()

    runCatching {
        sharedPreferences?.edit {
            putInt(key, value)
        }
    }
}

private const val PREFERENCE_NAME = "trainer"
private var sharedPreferences: SharedPreferences? = null
private fun KMPContext.initSharedPreferences() {
    sharedPreferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE)
}

actual val KMPContext.cachePath: Path?
    get() = runCatching { cacheDir.toOkioPath() }.getOrNull()
