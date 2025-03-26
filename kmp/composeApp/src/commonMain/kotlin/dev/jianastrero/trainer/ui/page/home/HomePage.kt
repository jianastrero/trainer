package dev.jianastrero.trainer.ui.page.home

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import dev.jianastrero.trainer.domain.enumeration.PokemonType
import dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon.Pokemon
import dev.jianastrero.trainer.ui.molecule.SwipeAction
import dev.jianastrero.trainer.ui.molecule.SwipeButtons
import dev.jianastrero.trainer.ui.organism.PokemonCard
import dev.jianastrero.trainer.ui.template.AppBarTemplate
import dev.jianastrero.trainer.ui.theme.TrainerTheme
import kotlinx.coroutines.delay
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject

private data object CardAnimTokens {
    const val ANIM_X_OFFSET = 1.4f
    const val ANIM_Z_ROTATION = 30f
    const val ANIM_DURATION = 300
}

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
            onSwipeAction = { action, pokemon ->
                when (action) {
                    SwipeAction.Like -> viewModel.like(pokemon)
                    SwipeAction.Dislike -> viewModel.dislike(pokemon)
                }
            },
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        )
    }
}

@Composable
private fun HomePageContent(
    pokemons: List<Pokemon>,
    onSwipeAction: (SwipeAction, Pokemon) -> Unit,
    modifier: Modifier = Modifier
) {
    var containerSize by remember { mutableStateOf(Size.Zero) }
    val firstPokemon by remember(pokemons) {
        derivedStateOf {
            pokemons.firstOrNull()
        }
    }
    val secondPokemon by remember(pokemons) {
        derivedStateOf {
            pokemons.getOrNull(1)
        }
    }
    var swipeAction: SwipeAction? by remember {
        mutableStateOf(null)
    }

    val transition = updateTransition(swipeAction)
    val animTranslationX by transition.animateFloat(
        transitionSpec = {
            when {
                targetState == SwipeAction.Like ||
                targetState == SwipeAction.Dislike -> tween(durationMillis = CardAnimTokens.ANIM_DURATION)
                else -> tween(durationMillis = 0)
            }
        }
    ) {
        when (it) {
            SwipeAction.Like -> CardAnimTokens.ANIM_X_OFFSET * containerSize.width
            SwipeAction.Dislike -> -CardAnimTokens.ANIM_X_OFFSET * containerSize.width
            else -> 0f
        }
    }
    val animRotationZ by transition.animateFloat(
        transitionSpec = {
            when {
                targetState == SwipeAction.Like ||
                        targetState == SwipeAction.Dislike -> tween(durationMillis = CardAnimTokens.ANIM_DURATION)
                else -> tween(durationMillis = 0)
            }
        }
    ) {
        when (it) {
            SwipeAction.Like -> CardAnimTokens.ANIM_Z_ROTATION
            SwipeAction.Dislike -> -CardAnimTokens.ANIM_Z_ROTATION
            else -> 0f
        }
    }

    LaunchedEffect(transition.isRunning) {
        val action = swipeAction
        val pokemon = firstPokemon
        if (!transition.isRunning && action != null && pokemon != null) {
            onSwipeAction(action, pokemon)
            swipeAction = null
        }
    }

    Box(
        modifier = Modifier
            .onGloballyPositioned { containerSize = it.size.toSize() }
            .then(modifier)
    ) {
        secondPokemon?.let { pokemon ->
            PokemonCard(
                zIndex = 0,
                name = pokemon.name,
                previewImageUrl = pokemon.sprites.otherSprites.officialArtwork.frontDefault,
                color = pokemon.types.firstOrNull()?.type?.name?.color ?: PokemonType.Normal.color,
                modifier = Modifier
                    .padding(
                        start = 32.dp,
                        end = 32.dp,
                        top = 8.dp,
                        bottom = 50.dp
                    )
                    .fillMaxSize()
            )
        }
        firstPokemon?.let { pokemon ->
            PokemonCard(
                zIndex = 2,
                name = pokemon.name,
                previewImageUrl = pokemon.sprites.otherSprites.officialArtwork.frontDefault,
                color = pokemon.types.firstOrNull()?.type?.name?.color ?: PokemonType.Normal.color,
                modifier = Modifier
                    .padding(
                        start = 32.dp,
                        end = 32.dp,
                        top = 8.dp,
                        bottom = 50.dp
                    )
                    .fillMaxSize()
                    .graphicsLayer {
                        translationX = animTranslationX
                        rotationZ = animRotationZ
                    }
            )
        }

        SwipeButtons(
            onAction = { swipeAction = it },
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
            pokemons = listOf(Pokemon.Sample, Pokemon.Sample),
            onSwipeAction = { _, _ -> },
            modifier = Modifier
                .fillMaxSize()
        )
    }
}
