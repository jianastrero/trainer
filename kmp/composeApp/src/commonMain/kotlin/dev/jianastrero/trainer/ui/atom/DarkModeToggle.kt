package dev.jianastrero.trainer.ui.atom

import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import org.jetbrains.compose.resources.stringResource
import trainer.composeapp.generated.resources.Res
import trainer.composeapp.generated.resources.toggle_dark_mode

@Composable
fun DarkModeToggle(
    isDarkMode: Boolean,
    onToggle: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Icon(
        imageVector = if (isDarkMode) Icons.Outlined.DarkMode else Icons.Outlined.LightMode,
        contentDescription = stringResource(Res.string.toggle_dark_mode),
        tint = MaterialTheme.colors.onBackground,
        modifier = Modifier
            .clip(CircleShape)
            .clickable(enabled = enabled) { onToggle(!isDarkMode) }
            .then(modifier)
    )
}
