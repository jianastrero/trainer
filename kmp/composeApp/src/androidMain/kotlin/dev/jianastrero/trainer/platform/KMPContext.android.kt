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

private const val PREFERENCE_NAME = "trainer"
private var sharedPreferences: SharedPreferences? = null
private fun KMPContext.initSharedPreferences() {
    sharedPreferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE)
}

actual val KMPContext.cachePath: Path?
    get() = runCatching { cacheDir.toOkioPath() }.getOrNull()
