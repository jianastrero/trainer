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
import androidx.compose.ui.unit.dp
import dev.jianastrero.trainer.domain.enumeration.PokemonType
import dev.jianastrero.trainer.ui.organism.PokemonCard
import dev.jianastrero.trainer.ui.page.main.MainViewModel
import dev.jianastrero.trainer.ui.template.AppBarTemplate
import dev.jianastrero.trainer.ui.theme.TrainerTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject

@Composable
fun HomePage(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinInject(),
) {
    val isDarkMode by viewModel.isDarkMode.collectAsState()
    val pokemons by viewModel.pokemons.collectAsState()

    LaunchedEffect(pokemons) {
        if (pokemons.size <= 5) {
            viewModel.getNextPokemons()
        }
    }

    AppBarTemplate(
        isDarkMode = isDarkMode,
        onDarkModeToggle = viewModel::setDarkMode,
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
            if (pokemons.isNotEmpty()) {
                val pokemon = pokemons.first()
                PokemonCard(
                    zIndex = 2,
                    name = pokemon.name,
                    previewImageUrl = pokemon.sprites.otherSprites.officialArtwork.frontDefault,
                    color = pokemon.types.firstOrNull()?.type?.name?.color ?: PokemonType.Normal.color,
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
        HomePage(modifier = Modifier.fillMaxSize())
    }
}
