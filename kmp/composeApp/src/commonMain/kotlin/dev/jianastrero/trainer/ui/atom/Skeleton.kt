package dev.jianastrero.trainer.ui.atom

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode

@Composable
fun Skeleton(
    modifier: Modifier = Modifier,
    background: Color = MaterialTheme.colors.onBackground.copy(alpha = 0.1f),
    shimmer: Color = MaterialTheme.colors.background.copy(alpha = 0.6f),
) {
    val infiniteTransition = rememberInfiniteTransition("skeleton")
    val transition by infiniteTransition.animateFloat(
        initialValue = 0.0f,
        targetValue = 1.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = LinearEasing
            )
        )
    )

    Box(
        modifier = modifier
            .background(background)
            .background(
                brush = Brush.linearGradient(
                    (transition - 0.1f) to background,
                    transition to shimmer,
                    (transition + 0.1f) to background,
                    tileMode = TileMode.Repeated
                )
            )
    )
}
