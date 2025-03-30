package dev.jianastrero.trainer.ui.navgraph

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.jianastrero.trainer.domain.nav.NavDirection
import dev.jianastrero.trainer.ui.page.home.HomePage
import dev.jianastrero.trainer.ui.page.matches.MatchesPage

@Composable
fun BottomNavGraph(
    mainNavController: NavHostController,
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val navigate: (NavDirection) -> Unit = { direction ->
        when (direction) {
            is NavDirection.Back -> {
                mainNavController.popBackStack()
            }
            is NavDirection.Screen -> {
                mainNavController.navigate(direction)
            }
            else -> navController.navigate(direction)
        }
    }

    NavHost(
        navController = navController,
        startDestination = NavDirection.BottomNav.Swipe,
        modifier = modifier
    ) {
        composable<NavDirection.BottomNav.Swipe> {
            HomePage(
                navigate = navigate,
                modifier = Modifier.fillMaxSize()
            )
        }

        composable<NavDirection.BottomNav.Matches> {
            MatchesPage(
                navigate = navigate,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
