package dev.jianastrero.trainer.ui.page.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import dev.jianastrero.trainer.ui.page.main.MainViewModel
import dev.jianastrero.trainer.ui.template.AppBarTemplate
import org.koin.compose.koinInject

@Composable
fun HomePage(
    mainViewModel: MainViewModel,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinInject(),
) {
    val isDarkMode by mainViewModel.isDarkMode.collectAsState()

    AppBarTemplate(
        isDarkMode = isDarkMode,
        onDarkModeToggle = mainViewModel::setDarkMode,
        modifier = modifier
    ) { paddingValues ->

    }
}
