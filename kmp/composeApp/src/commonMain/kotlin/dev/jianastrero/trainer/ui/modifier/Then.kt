package dev.jianastrero.trainer.ui.modifier

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

fun Modifier.then(
    condition: Boolean,
    modifierBlock: @Composable () -> Modifier
): Modifier = composed {
    then(
        if (condition) {
            modifierBlock()
        } else {
            Modifier
        }
    )
}
