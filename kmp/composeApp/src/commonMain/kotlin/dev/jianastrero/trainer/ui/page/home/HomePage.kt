package dev.jianastrero.trainer.ui.page.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.jianastrero.trainer.domain.enumeration.PokemonType
import dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon.Pokemon
import dev.jianastrero.trainer.ui.molecule.SwipeButtons
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
        HomePageContent(
            pokemons = pokemons,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        )
    }
}

@Composable
private fun HomePageContent(
    pokemons: List<Pokemon>,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        if (pokemons.isNotEmpty()) {
            val pokemon = pokemons.first()
            PokemonCard(
                zIndex = 2,
                name = pokemon.name,
                previewImageUrl = pokemon.sprites.otherSprites.officialArtwork.frontDefault,
                color = pokemon.types.firstOrNull()?.type?.name?.color ?: PokemonType.Normal.color,
                modifier = Modifier
                    .padding(
                        horizontal = 32.dp,
                        vertical = 72.dp
                    )
                    .fillMaxSize()
            )
        }
        SwipeButtons(
            onAction = {},
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(12.dp)
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
private fun HomePageContentPreview() {
    TrainerTheme {
        HomePageContent(
            pokemons = listOf(Pokemon.Sample),
            modifier = Modifier
                .fillMaxSize()
        )
    }
}
