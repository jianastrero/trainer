package dev.jianastrero.trainer.ui.organism

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.jianastrero.trainer.ui.atom.DarkModeToggle
import dev.jianastrero.trainer.ui.atom.TrainerTextLogo
import dev.jianastrero.trainer.ui.theme.TrainerTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun AppBar(
    title: String?,
    onDarkModeToggle: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(
                horizontal = 12.dp,
                vertical = 8.dp
            )
    ) {
        if (title == null) {
            TrainerTextLogo(
                modifier = Modifier
                    .height(32.dp)
                    .padding(4.dp)
            )
        } else {
            Text(
                text = title,
                color = MaterialTheme.colors.onBackground,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 16.sp,
                modifier = Modifier
                    .height(32.dp)
                    .padding(4.dp)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        DarkModeToggle(
            isDarkMode = TrainerTheme.isDarkMode,
            onToggle = onDarkModeToggle,
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
            AppBar(
                title = null,
                onDarkModeToggle = {}
            )
            AppBar(
                title = "Matches",
                onDarkModeToggle = {}
            )
        }
    }
}
