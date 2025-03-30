package dev.jianastrero.trainer.ui.navgraph

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import dev.jianastrero.trainer.domain.enumeration.BottomNavItem
import dev.jianastrero.trainer.domain.nav.NavDirection
import dev.jianastrero.trainer.ui.page.details.PokemonDetailsPage
import dev.jianastrero.trainer.ui.template.BottomNavTemplate

@Composable
fun MainNavGraph(
    mainNavController: NavHostController,
    selectedBottomNavItem: BottomNavItem,
    setSelectedBottomNavItem: (BottomNavItem) -> Unit,
    modifier: Modifier = Modifier
) {
    val navigate: (NavDirection) -> Unit = { direction ->
        when (direction) {
            is NavDirection.Back -> {
                mainNavController.popBackStack()
            }
            else -> mainNavController.navigate(direction)
        }
    }

    NavHost(
        navController = mainNavController,
        startDestination = NavDirection.Screen.Main,
        modifier = modifier
    ) {
        composable<NavDirection.Screen.Main> {
            val bottomNavController = rememberNavController()

            BottomNavTemplate(
                selected = selectedBottomNavItem,
                onSelectBottomNavItem = { bottomNavItem ->
                    val destination = when (bottomNavItem) {
                        BottomNavItem.Swipe -> NavDirection.BottomNav.Swipe
                        BottomNavItem.Matches -> NavDirection.BottomNav.Matches
                    }
                    bottomNavController.navigate(destination)
                    setSelectedBottomNavItem(bottomNavItem)
                },
                modifier = Modifier
                    .fillMaxSize()
                    .systemBarsPadding()
            ) { paddingValues ->
                BottomNavGraph(
                    navController = bottomNavController,
                    mainNavController = mainNavController,
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
