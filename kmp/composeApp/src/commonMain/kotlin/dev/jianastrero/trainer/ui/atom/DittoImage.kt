package dev.jianastrero.trainer.ui.atom

import androidx.compose.foundation.Image
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import org.jetbrains.compose.resources.painterResource
import trainer.composeapp.generated.resources.Res
import trainer.composeapp.generated.resources.ditto

@Composable
fun DittoImage(modifier: Modifier = Modifier) {
    Icon(
        painter = painterResource(Res.drawable.ditto),
        contentDescription = "Ditto",
        modifier = modifier
    )
}
