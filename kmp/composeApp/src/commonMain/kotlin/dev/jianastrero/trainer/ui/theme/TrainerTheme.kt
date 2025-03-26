package dev.jianastrero.trainer.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

private var _isDarkMode by mutableStateOf(false)

data object TrainerTheme {
    val isDarkMode: Boolean
        get() = _isDarkMode
}

@Composable
fun TrainerTheme(
    isDarkMode: Boolean = false,
    content: @Composable () -> Unit
) {
    LaunchedEffect(isDarkMode) {
        _isDarkMode = isDarkMode
    }

    MaterialTheme(
        colors = if (isDarkMode) TrainerDarkColors else TrainerLightColors,
        shapes = TrainerShapes,
        typography = trainerTypography(),
        content = content
    )
}
