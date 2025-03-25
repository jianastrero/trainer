package dev.jianastrero.trainer.ui.effect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import platform.UIKit.UIApplication
import platform.UIKit.UIStatusBarStyleDarkContent
import platform.UIKit.UIStatusBarStyleLightContent
import platform.UIKit.setStatusBarStyle

@Composable
actual fun SystemBarIconColorEffect(isDarkMode: Boolean) {
    DisposableEffect(isDarkMode) {
        val oldStatusBarStyle = UIApplication.sharedApplication.statusBarStyle

        val style = if (isDarkMode) {
            UIStatusBarStyleLightContent
        } else {
            UIStatusBarStyleDarkContent
        }

        UIApplication.sharedApplication.setStatusBarStyle(style)

        onDispose {
            UIApplication.sharedApplication.setStatusBarStyle(oldStatusBarStyle)
        }
    }
}
