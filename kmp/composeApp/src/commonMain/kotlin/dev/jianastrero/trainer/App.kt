package dev.jianastrero.trainer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.jianastrero.trainer.ui.effect.SystemBarIconColorEffect
import dev.jianastrero.trainer.ui.page.main.MainPage
import dev.jianastrero.trainer.ui.theme.TrainerTheme

@Composable
fun App() {
    SystemBarIconColorEffect(false)

    TrainerTheme {
        MainPage(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .fillMaxSize()
                .systemBarsPadding()
        )
    }
}
