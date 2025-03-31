package dev.jianastrero.trainer.ui.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dev.jianastrero.trainer.ui.organism.AppBar
import dev.jianastrero.trainer.ui.organism.BackButtonAppBar
import dev.jianastrero.trainer.ui.theme.TrainerTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun BackButtonTemplate(
    onBack: () -> Unit,
    onDarkModeToggle: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Column(modifier = modifier) {
        BackButtonAppBar(
            onBack = onBack,
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
private fun PreviewPokemonDetailTemplate() {
    TrainerTheme {
        BackButtonTemplate(
            onBack = {},
            onDarkModeToggle = {},
            modifier = Modifier.background(Color.Red).fillMaxSize()
        ) {}
    }
}
