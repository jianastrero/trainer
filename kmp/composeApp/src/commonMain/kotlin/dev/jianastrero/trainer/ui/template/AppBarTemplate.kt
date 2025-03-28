package dev.jianastrero.trainer.ui.template

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
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
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
            AppBar(
                onDarkModeToggle = onDarkModeToggle,
                modifier = Modifier.fillMaxWidth()
            )
        },
        content = content,
        modifier = modifier,
    )
}

@Preview
@Composable
private fun AppBarsTemplatePreview() {
    TrainerTheme {
        AppBarTemplate(
            onDarkModeToggle = {}
        ) {
            Box(modifier = Modifier.fillMaxSize().padding(it)) {
                Text(
                    "Content",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}
