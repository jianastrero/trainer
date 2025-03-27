package dev.jianastrero.trainer.ui.page.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import dev.jianastrero.trainer.domain.nav.NavDirection
import dev.jianastrero.trainer.ui.page.details.PokemonDetailsPage
import dev.jianastrero.trainer.ui.page.home.HomePage
import dev.jianastrero.trainer.ui.template.BottomNavTemplate

@Composable
fun MainPage(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    val selectedBottomNavItem by viewModel.selectedBottomNavItem.collectAsState()

    val navigate: (NavDirection) -> Unit = { direction ->
        when (direction) {
            is NavDirection.Back -> {
                navController.popBackStack()
            }
            else -> navController.navigate(direction)
        }
    }

    NavHost(
        navController = navController,
        startDestination = NavDirection.Screen.Main,
        modifier = modifier
    ) {
        composable<NavDirection.Screen.Main> {
            BottomNavTemplate(
                selected = selectedBottomNavItem,
                onSelectBottomNavItem = viewModel::setSelectedBottomNavItem,
                modifier = Modifier
                    .fillMaxSize()
                    .systemBarsPadding()
            ) { paddingValues ->
                HomePage(
                    navigate = navigate,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                )
            }
        }

        composable<NavDirection.Screen.PokemonDetail> { backStackEntry ->
            val pokemon = backStackEntry.toRoute<NavDirection.Screen.PokemonDetail>()

            PokemonDetailsPage(
                navigate = navigate,
                pokemonId = pokemon.id,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
