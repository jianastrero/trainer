package dev.jianastrero.trainer.ui.page.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import dev.jianastrero.trainer.ui.page.home.HomePage
import dev.jianastrero.trainer.ui.template.BottomNavTemplate

@Composable
fun MainPage(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier,
) {
    val selectedBottomNavItem by viewModel.selectedBottomNavItem.collectAsState()

    BottomNavTemplate(
        selected = selectedBottomNavItem,
        onSelectBottomNavItem = viewModel::setSelectedBottomNavItem,
        modifier = modifier
    ) { paddingValues ->
        HomePage(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
        )
    }
}
