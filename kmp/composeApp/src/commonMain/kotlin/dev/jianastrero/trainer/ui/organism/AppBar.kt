package dev.jianastrero.trainer.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.jianastrero.trainer.ui.atom.DarkModeToggle
import dev.jianastrero.trainer.ui.atom.TrainerTextLogo
import dev.jianastrero.trainer.ui.theme.TrainerTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun AppBar(
    onDarkModeToggle: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    var isDarkMode by remember { mutableStateOf(false) }

    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(
                horizontal = 12.dp,
                vertical = 8.dp
            )
    ) {
        TrainerTextLogo(
            modifier = Modifier
                .height(32.dp)
                .padding(4.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        DarkModeToggle(
            isDarkMode = isDarkMode,
            onToggle = {
                isDarkMode = it
                onDarkModeToggle(isDarkMode)
            },
            modifier = Modifier
                .size(32.dp)
                .padding(4.dp)
        )
    }
}

@Preview
@Composable
private fun AppBarPreview() {
    TrainerTheme {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            AppBar(onDarkModeToggle = {})
        }
    }
}
