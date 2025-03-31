package dev.jianastrero.trainer.ui.atom

import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import dev.jianastrero.trainer.ui.theme.TrainerTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import trainer.composeapp.generated.resources.Res
import trainer.composeapp.generated.resources.ic_dark_mode
import trainer.composeapp.generated.resources.ic_light_mode
import trainer.composeapp.generated.resources.toggle_dark_mode

@Composable
fun DarkModeToggle(
    isDarkMode: Boolean,
    onToggle: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Icon(
        painter = painterResource(if (isDarkMode) Res.drawable.ic_dark_mode else Res.drawable.ic_light_mode),
        contentDescription = stringResource(Res.string.toggle_dark_mode),
        tint = TrainerTheme.colors.onBackground,
        modifier = Modifier
            .clip(CircleShape)
            .clickable(enabled = enabled) { onToggle(!isDarkMode) }
            .then(modifier)
    )
}
