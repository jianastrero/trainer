package dev.jianastrero.trainer.ui.page.details

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import dev.jianastrero.trainer.ui.organism.ImageViewPager
import dev.jianastrero.trainer.ui.organism.PokemonHeader
import dev.jianastrero.trainer.ui.template.BackButtonTemplate
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
    val pokemon by viewModel.pokemon.collectAsState()
    val background by animateColorAsState(
        if (pokemon == null) {
            MaterialTheme.colors.background
        } else {
            pokemon?.type?.color?.copy(alpha = 0.72f) ?: MaterialTheme.colors.background
        },
        animationSpec = tween(PokemonDetailsPageTokens.REVEAL_ANIM_DURATION)
    )

    val images by remember(pokemon) {
        derivedStateOf {
            List(10) {
                pokemon?.officialArtwork
            }.filterNotNull()
        }
    }

    LaunchedEffect(pokemonId) {
        viewModel.getPokemon(pokemonId)
    }

    BackButtonTemplate(
        onBack = { navigate(NavDirection.Back) },
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
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {
                PokemonHeader(
                    pokemon = pokemon,
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 12.dp)
                )
            }
            item {
                ImageViewPager(
                    images = images,
                    modifier = Modifier
                        .fillMaxWidth()
                )
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
