package dev.jianastrero.trainer.ui.page.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import dev.jianastrero.trainer.domain.screen.Screen
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

    BottomNavTemplate(
        selected = selectedBottomNavItem,
        onSelectBottomNavItem = viewModel::setSelectedBottomNavItem,
        modifier = modifier
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Main
        ) {
            composable<Screen.Main> {
                HomePage(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                )
            }

            composable<Screen.PokemonDetail> { backStackEntry ->
                val pokemon = backStackEntry.toRoute<Screen.PokemonDetail>()
                PokemonDetailsPage(
                    pokemonId = pokemon.id,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                )
            }
        }
    }
}
