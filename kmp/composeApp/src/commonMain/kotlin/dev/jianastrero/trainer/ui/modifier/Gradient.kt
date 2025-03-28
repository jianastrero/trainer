package dev.jianastrero.trainer.ui.modifier

import androidx.compose.foundation.background
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.toSize

data object RadialGradientTokens {
    const val GRADIENT_RADIUS = 0.9f

    enum class Bias {
        Width,
        Height
    }
}

fun Modifier.background(
    radialColor: Color,
    backgroundColor: Color,
    radius: Float = RadialGradientTokens.GRADIENT_RADIUS,
    radiusBias: RadialGradientTokens.Bias = RadialGradientTokens.Bias.Width,
    shape: Shape = RectangleShape
): Modifier = composed {
    var size by remember { mutableStateOf(Size.Unspecified) }

    this.onGloballyPositioned {
        size = it.size.toSize()
    }.background(
        brush = Brush.radialGradient(
            0f to radialColor,
            1f to backgroundColor,
            center = if (size == Size.Unspecified) Offset.Zero else size.center.copy(y = 0f),
            radius = if (size == Size.Unspecified) Float.POSITIVE_INFINITY
            else {
                when (radiusBias) {
                    RadialGradientTokens.Bias.Width -> size.width
                    RadialGradientTokens.Bias.Height -> size.height
                } * radius
            }
        ),
        shape = shape
    )
}
