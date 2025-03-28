package dev.jianastrero.trainer.ui.organism

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import dev.jianastrero.trainer.ui.atom.DarkModeToggle
import dev.jianastrero.trainer.ui.theme.TrainerTheme

@Composable
fun BackButtonAppBar(
    onBack: () -> Unit,
    onDarkModeToggle: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
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
        Icon(
            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
            contentDescription = "Back",
            tint = MaterialTheme.colors.onBackground,
            modifier = Modifier
                .size(32.dp)
                .padding(4.dp)
                .clip(CircleShape)
                .clickable(enabled = enabled, onClick = onBack)
        )
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
