package dev.jianastrero.trainer.ui.atom

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dev.jianastrero.trainer.ui.modifier.skeleton
import dev.jianastrero.trainer.ui.theme.TrainerTheme

@Composable
fun Skeleton(
    modifier: Modifier = Modifier,
    background: Color = TrainerTheme.colors.onBackground.copy(alpha = 0.1f),
    shimmer: Color = TrainerTheme.colors.background.copy(alpha = 0.6f),
) {
    Box(
        modifier = modifier.skeleton(
            background = background,
            shimmer = shimmer,
        )
    )
}
