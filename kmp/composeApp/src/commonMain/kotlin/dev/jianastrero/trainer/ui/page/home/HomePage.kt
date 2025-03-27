package dev.jianastrero.trainer.ui.page.home

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
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
import androidx.compose.ui.input.key.Key.Companion.L
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import dev.jianastrero.trainer.domain.enumeration.PokemonType
import dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon.Pokemon
import dev.jianastrero.trainer.ui.molecule.SwipeAction
import dev.jianastrero.trainer.ui.molecule.SwipeButtons
import dev.jianastrero.trainer.ui.organism.CardAction
import dev.jianastrero.trainer.ui.organism.PokemonCard
import dev.jianastrero.trainer.ui.page.home.type
import dev.jianastrero.trainer.ui.template.AppBarTemplate
import dev.jianastrero.trainer.ui.theme.TrainerTheme
import kotlinx.coroutines.NonCancellable.start
import kotlinx.coroutines.delay
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
    var cardAction by remember { mutableStateOf<CardAction?>(null) }

    Box(modifier = modifier) {
        PokemonCards(
            cardAction = cardAction,
            onCardAction = { action ->
                cardAction = action
            },
            onSwipeAction = onSwipeAction,
            pokemons = pokemons,
            modifier = Modifier
                .padding(
                    start = 32.dp,
                    end = 32.dp,
                    top = 8.dp,
                    bottom = 50.dp
                )
                .fillMaxSize()
        )

        SwipeButtons(
            enabled = cardAction == null,
            onAction = { action ->
                cardAction = when (action) {
                    SwipeAction.Like -> CardAction.SwipeRight
                    SwipeAction.Dislike -> CardAction.SwipeLeft
                }
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(12.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
private fun PokemonCards(
    cardAction: CardAction?,
    onCardAction: (CardAction?) -> Unit,
    onSwipeAction: (SwipeAction, Pokemon) -> Unit,
    pokemons: List<Pokemon>,
    modifier: Modifier = Modifier
) {
    val firstPokemon by remember(pokemons) {
        derivedStateOf {
            pokemons.firstOrNull()
        }
    }
    var secondPokemon by remember { mutableStateOf<Pokemon?>(null) }

    LaunchedEffect(pokemons, firstPokemon) {
        secondPokemon = pokemons.getOrNull(1)
    }

    Box(modifier = modifier) {
        PokemonCard(
            enabled = false,
            name = secondPokemon?.name.orEmpty(),
            previewImageUrl = secondPokemon.officialArtwork,
            color = secondPokemon.type.color,
        )
        PokemonCard(
            name = firstPokemon?.name.orEmpty(),
            previewImageUrl = firstPokemon.officialArtwork,
            color = firstPokemon.type.color,
            cardAction = cardAction,
            onCardAction = onCardAction@{ action ->
                val swipeAction = when (action) {
                    CardAction.SwipeRight -> SwipeAction.Like
                    CardAction.SwipeLeft -> SwipeAction.Dislike
                    else -> null
                } ?: return@onCardAction
                val pokemon = firstPokemon ?: return@onCardAction

                onSwipeAction(swipeAction, pokemon)
                onCardAction(null)
            },
        )
    }
}

private val Pokemon?.officialArtwork: String
    get() = this?.sprites?.otherSprites?.officialArtwork?.frontDefault.orEmpty()

private val Pokemon?.type: PokemonType
    get() = this?.types?.firstOrNull()?.type?.name ?: PokemonType.Unknown

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
