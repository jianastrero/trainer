package dev.jianastrero.trainer.ui.theme

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import dev.jianastrero.trainer.TrainerApp
import dev.jianastrero.trainer.platform.KMPContext

actual val LocalKMPContext: ProvidableCompositionLocal<KMPContext> = staticCompositionLocalOf {
    TrainerApp.instance
}
