package dev.jianastrero.trainer.ui.molecule

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.jianastrero.trainer.ui.atom.PageIndicator
import dev.jianastrero.trainer.ui.theme.TrainerTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun PageIndicators(
    currentPage: Int,
    pageCount: Int,
    modifier: Modifier = Modifier,
    activeColor: Color = TrainerTheme.colors.background,
    inactiveColor: Color = TrainerTheme.colors.background.copy(alpha = 0.48f),
    borderColor: Color? = null,
    spacing: Dp = 12.dp
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(spacing, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        repeat(pageCount) { index ->
            val isActive = currentPage == index
            val size by animateDpAsState(
                targetValue = if (isActive) 12.dp else 6.dp,
                label = "PageIndicatorSizeAnimation",
            )
            PageIndicator(
                active = isActive,
                activeColor = activeColor,
                inactiveCcolor = inactiveColor,
                borderColor = borderColor,
                modifier = Modifier.size(size)
            )
        }
    }
}

@Preview
@Composable
private fun PageIndicatorsPreview() {
    TrainerTheme {
        PageIndicators(
            currentPage = 0,
            pageCount = 3,
            modifier = Modifier
                .size(144.dp, 32.dp)
        )
    }
}
