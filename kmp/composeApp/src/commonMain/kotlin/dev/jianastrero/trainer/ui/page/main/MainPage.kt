package dev.jianastrero.trainer.ui.page.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import dev.jianastrero.trainer.ui.template.AppBarTemplate

@Composable
fun MainPage(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier,
) {
    val isDarkMode by viewModel.isDarkMode.collectAsState()

    AppBarTemplate(
        isDarkMode = isDarkMode,
        onDarkModeToggle = viewModel::setDarkMode,
        modifier = modifier
    ) { paddingValues ->

    }
}
