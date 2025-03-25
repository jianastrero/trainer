package dev.jianastrero.trainer.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun TrainerTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) TrainerDarkColors else TrainerLightColors,
        shapes = TrainerShapes,
        content = content
    )
}
