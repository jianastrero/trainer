package dev.jianastrero.trainer.ui.template

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.jianastrero.trainer.ui.organism.AppBar
import dev.jianastrero.trainer.ui.theme.TrainerTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun AppBarTemplate(
    onDarkModeToggle: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    title: String? = null,
    content: @Composable () -> Unit
) {
    Column(modifier = modifier) {
        AppBar(
            title = title,
            onDarkModeToggle = onDarkModeToggle,
            modifier = Modifier.fillMaxWidth()
        )
        Box(modifier = Modifier.weight(1f)) {
            content()
        }
    }
}

@Preview
@Composable
private fun AppBarsTemplatePreview() {
    TrainerTheme {
        AppBarTemplate(
            onDarkModeToggle = {}
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    "Content",
                    style = TrainerTheme.typography.body1,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}
