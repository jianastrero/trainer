package dev.jianastrero.trainer.ui.modifier

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import dev.jianastrero.trainer.ui.theme.TrainerTheme

fun Modifier.skeleton(
    background: Color? = null,
    shimmer: Color? = null,
) = composed {
    val background = background ?: TrainerTheme.colors.onBackground.copy(alpha = 0.1f)
    val shimmer = shimmer ?: TrainerTheme.colors.background.copy(alpha = 0.6f)
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

    this.background(background)
        .background(
            brush = Brush.linearGradient(
                (transition - 0.1f) to background,
                transition to shimmer,
                (transition + 0.1f) to background,
                tileMode = TileMode.Repeated
            )
        )
}
