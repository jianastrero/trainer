package dev.jianastrero.trainer.ui.atom

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import dev.jianastrero.trainer.ui.theme.TrainerTheme
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import trainer.composeapp.generated.resources.Res
import trainer.composeapp.generated.resources.ic_love_active

@Composable
fun SwipeButton(
    icon: DrawableResource,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Box(
        modifier = modifier
            .alpha(if (enabled) 1f else 0.4f)
            .shadow(
                elevation = 2.dp,
                shape = MaterialTheme.shapes.large,
                ambientColor = MaterialTheme.colors.primary,
                spotColor = MaterialTheme.colors.primary
            )
            .background(
                color = MaterialTheme.colors.background,
                shape = MaterialTheme.shapes.large
            )
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.primary.copy(alpha = 0.1f),
                shape = MaterialTheme.shapes.medium
            )
            .clip(MaterialTheme.shapes.large)
            .clickable(enabled = enabled, onClick = onClick)
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .size(48.dp)
                .padding(12.dp)
        )
    }
}

@Preview
@Composable
private fun SwipeButtonPreview() {
    TrainerTheme {
        Box(modifier = Modifier.padding(64.dp)) {
            SwipeButton(
                Res.drawable.ic_love_active,
                onClick = {}
            )
        }
    }
}
