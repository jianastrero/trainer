package dev.jianastrero.trainer.ui.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dev.jianastrero.trainer.ui.organism.BackButtonAppBar
import dev.jianastrero.trainer.ui.theme.TrainerTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun BackButtonTemplate(
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        topBar = {
            BackButtonAppBar(
                onBack = onBack,
                modifier = Modifier.fillMaxWidth()
            )
        },
        backgroundColor = Color.Transparent,
        modifier = modifier
    ) { paddingValues ->
        content(paddingValues)
    }
}

@Preview
@Composable
private fun PreviewPokemonDetailTemplate() {
    TrainerTheme {
        BackButtonTemplate(
            onBack = {},
            modifier = Modifier.background(Color.Red).fillMaxSize()
        ) {}
    }
}
