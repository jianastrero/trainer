package dev.jianastrero.trainer.ui.atom

import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.jianastrero.trainer.ui.theme.TrainerTheme
import org.jetbrains.compose.resources.painterResource
import trainer.composeapp.generated.resources.Res
import trainer.composeapp.generated.resources.ditto

@Composable
fun DittoImage(modifier: Modifier = Modifier) {
    Icon(
        painter = painterResource(Res.drawable.ditto),
        contentDescription = "Ditto",
        tint = TrainerTheme.colors.onBackground,
        modifier = modifier
    )
}
