package dev.jianastrero.trainer.ui.atom

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.jianastrero.trainer.ui.theme.TrainerTheme

@Composable
fun TrainerButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    elevation: Dp = 8.dp,
    color: Color = TrainerTheme.colors.primary
) {
    Box(
        modifier = modifier
            .shadow(
                elevation = if (enabled) elevation else 0.dp,
                shape = TrainerTheme.shapes.large,
                spotColor = color,
                ambientColor = color,
            )
            .border(
                width = 1.dp,
                color = color.copy(alpha = if (enabled) 1f else 0.5f),
                shape = TrainerTheme.shapes.large
            )
            .background(
                color = TrainerTheme.colors.background,
                shape = TrainerTheme.shapes.large
            )
            .clip(TrainerTheme.shapes.large)
            .clickable(enabled = enabled, onClick = onClick)
            .padding(horizontal = 24.dp, vertical = 12.dp)
    ) {
        Text(
            text = text,
            style = TrainerTheme.typography.button.copy(
                color = color.copy(alpha = if (enabled) 1f else 0.5f)
            ),
            modifier = Modifier
        )
    }
}

