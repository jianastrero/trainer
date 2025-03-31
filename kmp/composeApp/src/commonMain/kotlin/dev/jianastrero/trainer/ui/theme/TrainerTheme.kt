package dev.jianastrero.trainer.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Colors
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import dev.jianastrero.trainer.platform.KMPContext

private var _isDarkMode by mutableStateOf(false)

data object TrainerTheme {
    val isDarkMode: Boolean
        get() = _isDarkMode

    val colors: Colors
        get() = if (_isDarkMode) TrainerDarkColors else TrainerLightColors

    val shapes: Shapes
        get() = TrainerShapes

    val typography: Typography
        @Composable
        get() = trainerTypography()
}

expect val LocalKMPContext: ProvidableCompositionLocal<KMPContext>

@Composable
fun TrainerTheme(
    isDarkMode: Boolean = true,
    content: @Composable () -> Unit
) {
    LaunchedEffect(isDarkMode) {
        _isDarkMode = isDarkMode
    }

    Box(modifier = Modifier.fillMaxSize()) {
        content()
    }
}
