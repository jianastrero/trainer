package dev.jianastrero.trainer.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

@Composable
fun TrainerTheme(
    isDarkMode: Boolean = false,
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colors = if (isDarkMode) TrainerDarkColors else TrainerLightColors,
        shapes = TrainerShapes,
        typography = trainerTypography(),
        content = content
    )
}
