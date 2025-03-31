package dev.jianastrero.trainer.ui.theme

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import dev.jianastrero.trainer.platform.KMPContext
import platform.darwin.NSObject

actual val LocalKMPContext: ProvidableCompositionLocal<KMPContext> = staticCompositionLocalOf {
    NSObject()
}
