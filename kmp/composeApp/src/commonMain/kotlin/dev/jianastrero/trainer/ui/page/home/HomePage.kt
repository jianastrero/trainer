package dev.jianastrero.trainer.ui.page.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.P
import androidx.compose.ui.unit.dp
import dev.jianastrero.trainer.ui.organism.PokemonCard
import dev.jianastrero.trainer.ui.page.main.MainViewModel
import dev.jianastrero.trainer.ui.template.AppBarTemplate
import dev.jianastrero.trainer.ui.theme.TrainerTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject

@Composable
fun HomePage(
    mainViewModel: MainViewModel,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinInject(),
) {
    val isDarkMode by mainViewModel.isDarkMode.collectAsState()
    val pokemonItems by viewModel.pokemonItems.collectAsState()

    LaunchedEffect(pokemonItems) {
        if (pokemonItems.size <= 5) {
            viewModel.getNextPokemons()
        }
    }

    AppBarTemplate(
        isDarkMode = isDarkMode,
        onDarkModeToggle = mainViewModel::setDarkMode,
        modifier = modifier.background(Color.Red)
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(
                    horizontal = 64.dp,
                    vertical = 128.dp
                )
        ) {
            if (pokemonItems.isNotEmpty()) {
                val pokemonItem = pokemonItems.first()
                PokemonCard(
                    zIndex = 2,
                    name = pokemonItem.name,
                    previewImageUrl = pokemonItem.imageUrl,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Preview
@Composable
private fun HomePagePreview() {
    TrainerTheme {
        HomePage(
            mainViewModel = koinInject(),
        )
    }
}
