package dev.jianastrero.trainer.ui.atom

import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dev.jianastrero.trainer.ui.modifier.skeleton

@Composable
fun Skeleton(
    modifier: Modifier = Modifier,
    background: Color = MaterialTheme.colors.onBackground.copy(alpha = 0.1f),
    shimmer: Color = MaterialTheme.colors.background.copy(alpha = 0.6f),
) {
    Box(
        modifier = modifier.skeleton(
            background = background,
            shimmer = shimmer,
        )
    )
}
