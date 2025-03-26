package dev.jianastrero.trainer.ui.atom

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import trainer.composeapp.generated.resources.Res
import trainer.composeapp.generated.resources.app_name
import trainer.composeapp.generated.resources.trainer_text_logo

@Composable
fun TrainerTextLogo(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(Res.drawable.trainer_text_logo),
        contentDescription = stringResource(Res.string.app_name),
        contentScale = ContentScale.Fit,
        modifier = modifier
    )
}
