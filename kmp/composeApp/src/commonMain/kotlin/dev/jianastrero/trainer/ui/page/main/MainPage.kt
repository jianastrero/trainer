package dev.jianastrero.trainer.ui.page.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dev.jianastrero.trainer.ui.navgraph.MainNavGraph

@Composable
fun MainPage(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier,
) {
    val mainNavController = rememberNavController()
    val selectedBottomNavItem by viewModel.selectedBottomNavItem.collectAsState()

    MainNavGraph(
        mainNavController = mainNavController,
        selectedBottomNavItem = selectedBottomNavItem,
        setSelectedBottomNavItem = viewModel::setSelectedBottomNavItem,
        modifier = modifier,
    )
}
