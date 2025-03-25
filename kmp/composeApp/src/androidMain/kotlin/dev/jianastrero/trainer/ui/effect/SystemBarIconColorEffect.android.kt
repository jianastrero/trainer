package dev.jianastrero.trainer.ui.effect

import android.os.Build
import android.view.View
import androidx.activity.compose.LocalActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat

@Composable
actual fun SystemBarIconColorEffect(isDarkMode: Boolean) {
    val window = LocalActivity.current?.window

    DisposableEffect(isDarkMode, window) {
        if (window == null) return@DisposableEffect onDispose {  }

        WindowCompat.setDecorFitsSystemWindows(window, false)
        val insetsController = WindowInsetsControllerCompat(window, window.decorView)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // Android 11 (R) and later
            insetsController.isAppearanceLightStatusBars = !isDarkMode
        } else {
            // Older versions (pre-Android 11)
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = if (isDarkMode) {
                window.decorView.systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
            } else {
                window.decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
        }

        onDispose {

        }
    }
}
