package dev.jianastrero.trainer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import dev.jianastrero.trainer.ui.effect.SystemBarIconColorEffect
import dev.jianastrero.trainer.ui.page.main.MainPage
import dev.jianastrero.trainer.ui.page.main.MainViewModel
import dev.jianastrero.trainer.ui.theme.TrainerTheme
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun App() {
    KoinContext {
        val viewModel = koinViewModel<MainViewModel>()
        val isDarkMode by viewModel.isDarkMode.collectAsState()

        SystemBarIconColorEffect(isDarkMode)

        TrainerTheme(isDarkMode = isDarkMode) {
            MainPage(
                viewModel = viewModel,
                modifier = Modifier
                    .background(TrainerTheme.colors.background)
                    .fillMaxSize()
            )
        }
    }
}
