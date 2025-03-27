package dev.jianastrero.trainer.ui.page.details

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import dev.jianastrero.trainer.domain.ext.type
import dev.jianastrero.trainer.domain.nav.NavDirection
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
    var size by remember { mutableStateOf(Size.Unspecified) }
    val pokemon by viewModel.pokemon.collectAsState()
    val background by animateColorAsState(
        if (pokemon == null) {
            MaterialTheme.colors.background
        } else {
            pokemon?.type?.color?.copy(alpha = 0.72f) ?: MaterialTheme.colors.background
        },
        animationSpec = tween(PokemonDetailsPageTokens.REVEAL_ANIM_DURATION)
    )

    LaunchedEffect(pokemonId) {
        viewModel.getPokemon(pokemonId)
    }

    BackButtonTemplate(
        onBack = { navigate(NavDirection.Back) },
        modifier = modifier
            .onGloballyPositioned { size = it.size.toSize() }
            .background(
                brush = Brush.radialGradient(
                    0f to background,
                    1f to MaterialTheme.colors.background,
                    center = if (size == Size.Unspecified) Offset.Zero else size.center.copy(y = 0f),
                    radius = if (size == Size.Unspecified) Float.POSITIVE_INFINITY else size.width * 1.4f
                ),
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
