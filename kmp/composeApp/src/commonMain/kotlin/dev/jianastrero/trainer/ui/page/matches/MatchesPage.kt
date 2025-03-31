package dev.jianastrero.trainer.ui.page.matches

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.jianastrero.trainer.domain.entity.primaryType
import dev.jianastrero.trainer.domain.nav.NavDirection
import dev.jianastrero.trainer.ui.organism.CardAction
import dev.jianastrero.trainer.ui.organism.PokemonCard
import dev.jianastrero.trainer.ui.template.AppBarTemplate
import dev.jianastrero.trainer.ui.theme.TrainerTheme
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MatchesPage(
    navigate: (NavDirection) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: MatchesViewModel = koinViewModel(),
) {
    val likedPokemons by viewModel.likedPokemons.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getLikedPokemons()
    }

    AppBarTemplate(
        title = "Matches",
        onDarkModeToggle = viewModel::setDarkMode,
        modifier = modifier,
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(
                horizontal = 12.dp,
                vertical = 24.dp
            ),
            modifier = Modifier.fillMaxSize()
        ) {
            items(likedPokemons) { pokemon ->
                PokemonCard(
                    name = pokemon.name,
                    imageUrl = pokemon.officialArtwork,
                    color = pokemon.primaryType?.color ?: TrainerTheme.colors.onBackground,
                    fontSize = 16.sp,
                    onCardAction = {
                        if (it is CardAction.View) {
                            navigate(NavDirection.Screen.PokemonDetail(pokemon.id))
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(0.75f)
                        .padding(8.dp)
                )
            }
        }
    }
}
