package dev.jianastrero.trainer.ui.page.details

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.jianastrero.trainer.domain.ext.type
import dev.jianastrero.trainer.domain.nav.NavDirection
import dev.jianastrero.trainer.ui.modifier.RadialGradientTokens
import dev.jianastrero.trainer.ui.modifier.background
import dev.jianastrero.trainer.ui.molecule.PokemonAbout
import dev.jianastrero.trainer.ui.molecule.PokemonBaseStats
import dev.jianastrero.trainer.ui.organism.ImageViewPager
import dev.jianastrero.trainer.ui.organism.PokemonHeader
import dev.jianastrero.trainer.ui.template.BackButtonTemplate
import dev.jianastrero.trainer.ui.theme.Light
import dev.jianastrero.trainer.ui.theme.TrainerTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject

private data object PokemonDetailsPageTokens {
    const val REVEAL_ANIM_DURATION = 1000
}

@Composable
fun PokemonDetailsPage(
    navigate: (NavDirection) -> Unit,
    pokemonId: String,
    modifier: Modifier = Modifier,
    viewModel: PokemonDetailsViewModel = koinInject(),
) {
    val state by viewModel.state.collectAsState()
    val background by animateColorAsState(
        if (state.pokemon == null) {
            MaterialTheme.colors.background
        } else {
            state.pokemon?.type?.color?.copy(alpha = 0.72f) ?: MaterialTheme.colors.background
        },
        animationSpec = tween(PokemonDetailsPageTokens.REVEAL_ANIM_DURATION)
    )

    val images: List<String> by remember(state) {
        derivedStateOf {
            val officialArtwork = state.pokemon?.officialArtwork

            var cards = state.pokemonCards.map { it.images.large }
            if (officialArtwork != null) {
                cards = listOf(officialArtwork) + cards
            }

            return@derivedStateOf if (cards.size > 1) cards else emptyList()
        }
    }

    LaunchedEffect(pokemonId) {
        viewModel.getPokemon(pokemonId)
    }

    BackButtonTemplate(
        onBack = { navigate(NavDirection.Back) },
        onDarkModeToggle = viewModel::setDarkMode,
        modifier = modifier
            .background(
                radialColor = background,
                backgroundColor = MaterialTheme.colors.background,
                radius = 0.8f,
                radiusBias = RadialGradientTokens.Bias.Height
            )
            .systemBarsPadding()
    ) { paddingValues ->
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {
                PokemonHeader(
                    pokemon = state.pokemon,
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 12.dp)
                )
            }
            item {
                ImageViewPager(
                    images = images,
                    activePageIndicatorColor = state.pokemon?.type?.color ?: Light,
                    pageIndicatorSpacing = 2.dp,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
                PokemonAbout(
                    pokemon = state.pokemon,
                    species = state.pokemonSpecies,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                )
            }
            item {
                PokemonBaseStats(
                    stats = state.pokemon?.stats,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                )
            }
            item {
                Spacer(modifier = Modifier.height(64.dp))
            }
        }
    }
}

@Preview
@Composable
private fun PokemonDetailsPage() {
    TrainerTheme {
        PokemonDetailsPage(
            navigate = {},
            pokemonId = "1",
            modifier = Modifier.fillMaxSize()
        )
    }
}
