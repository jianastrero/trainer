package dev.jianastrero.trainer.ui.molecule

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.jianastrero.trainer.ui.atom.PageIndicator
import dev.jianastrero.trainer.ui.theme.TrainerTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun PageIndicators(
    currentPage: Int,
    pageCount: Int,
    modifier: Modifier = Modifier,
    activeColor: Color = MaterialTheme.colors.background,
    inactiveCcolor: Color = MaterialTheme.colors.background.copy(alpha = 0.48f),
    borderColor: Color? = null,
) {
    androidx.compose.foundation.layout.Row(
        horizontalArrangement = Arrangement.spacedBy(
            12.dp,
            Alignment.CenterHorizontally
        ),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        repeat(pageCount) { index ->
            PageIndicator(
                active = currentPage == index,
                activeColor = activeColor,
                inactiveCcolor = inactiveCcolor,
                borderColor = borderColor,
                modifier = Modifier.size(12.dp)
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
