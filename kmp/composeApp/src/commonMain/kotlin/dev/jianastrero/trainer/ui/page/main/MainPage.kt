package dev.jianastrero.trainer.ui.page.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.jianastrero.trainer.ui.template.AppBarTemplate
import org.koin.compose.koinInject

@Composable
fun MainPage(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = koinInject(),
) {
    AppBarTemplate(
        onDarkModeToggle = {},
        modifier = modifier
    ) { paddingValues ->

    }
}
