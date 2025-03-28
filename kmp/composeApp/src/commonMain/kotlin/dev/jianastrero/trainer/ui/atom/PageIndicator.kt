package dev.jianastrero.trainer.ui.atom

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import dev.jianastrero.trainer.domain.enumeration.PokemonType
import dev.jianastrero.trainer.ui.theme.TrainerTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun PageIndicator(
    active: Boolean,
    modifier: Modifier = Modifier,
    activeColor: Color = MaterialTheme.colors.background,
    inactiveCcolor: Color = MaterialTheme.colors.background.copy(alpha = 0.48f),
    borderColor: Color? = null,
    shape: Shape = CircleShape,
) {
    Spacer(
        modifier = modifier
            .background(
                color = if (active) activeColor else inactiveCcolor,
                shape = shape
            )
            .then(
                if (borderColor == null) {
                    Modifier
                } else {
                    Modifier.border(
                        width = 1.dp,
                        color = borderColor.copy(alpha = if (active) 0.5f else 0.2f),
                        shape = shape
                    )
                }
            )
    )
}

@Preview
@Composable
private fun PageIndicator() {
    TrainerTheme {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(PokemonType.Dragon.color)
                .size(1440.dp, 3120.dp)
                .padding(12.dp)
        ) {
            PageIndicator(
                active = true,
                modifier = Modifier.size(16.dp),
            )
            PageIndicator(
                active = false,
                modifier = Modifier.size(16.dp),
            )
        }
    }
}
