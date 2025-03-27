package dev.jianastrero.trainer.ui.molecule

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.jianastrero.trainer.ui.atom.SwipeButton
import dev.jianastrero.trainer.ui.theme.TrainerTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import trainer.composeapp.generated.resources.Res
import trainer.composeapp.generated.resources.ic_dislike
import trainer.composeapp.generated.resources.ic_like

enum class SwipeAction {
    Like,
    Dislike
}

@Composable
fun SwipeButtons(
    onAction: (action: SwipeAction) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        SwipeButton(
            icon = Res.drawable.ic_dislike,
            onClick = { onAction(SwipeAction.Dislike) },
            enabled = enabled,
            modifier = Modifier.size(64.dp)
        )

        SwipeButton(
            icon = Res.drawable.ic_like,
            onClick = { onAction(SwipeAction.Like) },
            enabled = enabled,
            modifier = Modifier.size(64.dp)
        )
    }
}

@Preview
@Composable
private fun SwipeButtonsPreview() {
    TrainerTheme {
        SwipeButtons(
            onAction = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}
