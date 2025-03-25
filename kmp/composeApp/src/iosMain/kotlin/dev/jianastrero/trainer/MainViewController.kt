package dev.jianastrero.trainer

import androidx.compose.ui.window.ComposeUIViewController
import dev.jianastrero.trainer.di.initKoin
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController {
    App()
}
