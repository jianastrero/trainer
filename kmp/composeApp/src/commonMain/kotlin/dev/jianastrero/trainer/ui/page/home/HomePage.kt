package dev.jianastrero.trainer.ui.page.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.jianastrero.trainer.domain.entity.Pokemon
import dev.jianastrero.trainer.domain.entity.primaryType
import dev.jianastrero.trainer.domain.nav.NavDirection
import dev.jianastrero.trainer.ui.molecule.SwipeAction
import dev.jianastrero.trainer.ui.molecule.SwipeButtons
import dev.jianastrero.trainer.ui.organism.CardAction
import dev.jianastrero.trainer.ui.organism.PokemonCard
import dev.jianastrero.trainer.ui.template.AppBarTemplate
import org.koin.compose.koinInject

private data object HomePageTokens {
    val MIN_POKEMONS = 5
}

@Composable
fun HomePage(
    navigate: (NavDirection) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinInject(),
) {
    val pokemons by viewModel.pokemons.collectAsState()

    LaunchedEffect(pokemons) {
        if (pokemons.size <= HomePageTokens.MIN_POKEMONS) {
            viewModel.getNextPokemons()
        }
    }

    AppBarTemplate(
        onDarkModeToggle = viewModel::setDarkMode,
        modifier = modifier.background(Color.Red)
    ) { paddingValues ->
        HomePageContent(
            pokemons = pokemons,
            onView = {
                navigate(NavDirection.Screen.PokemonDetail(it))
            },
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
    onView: (pokemonId: String) -> Unit,
    onSwipeAction: (SwipeAction, Pokemon) -> Unit,
    modifier: Modifier = Modifier
) {
    var cardAction by remember { mutableStateOf<CardAction?>(null) }

    Box(modifier = modifier) {
        PokemonCards(
            cardAction = cardAction,
            onView = onView,
            onCardAction = { cardAction = it},
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
    onView: (String) -> Unit,
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
            imageUrl = secondPokemon?.officialArtwork.orEmpty(),
            color = secondPokemon?.primaryType?.color ?: MaterialTheme.colors.onBackground,
        )
        PokemonCard(
            name = firstPokemon?.name.orEmpty(),
            imageUrl = firstPokemon?.officialArtwork.orEmpty(),
            color = firstPokemon?.primaryType?.color ?: MaterialTheme.colors.onBackground,
            cardAction = cardAction,
            onCardAction = onCardAction@{ action ->
                val swipeAction = when (action) {
                    CardAction.SwipeRight -> SwipeAction.Like
                    CardAction.SwipeLeft -> SwipeAction.Dislike
                    CardAction.View -> return@onCardAction onView(firstPokemon?.id?.toString().orEmpty())
                }
                val pokemon = firstPokemon ?: return@onCardAction

                onSwipeAction(swipeAction, pokemon)
                onCardAction(null)
            },
        )
    }
}
