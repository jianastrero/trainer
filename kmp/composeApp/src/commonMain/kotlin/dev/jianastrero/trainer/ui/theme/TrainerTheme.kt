package dev.jianastrero.trainer.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TrainerTheme(
    modifier: Modifier = Modifier,
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) TrainerDarkColors else TrainerLightColors,
        shapes = TrainerShapes,
    ) {
        Surface(
            content = content,
            color = MaterialTheme.colors.background,
            contentColor = MaterialTheme.colors.onBackground,
            modifier = modifier,
        )
    }
}
