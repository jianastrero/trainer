package dev.jianastrero.trainer.ui.modifier

import androidx.compose.ui.Modifier

fun Modifier.then(
    condition: Boolean,
    modifierBlock: () -> Modifier
): Modifier = then(
    if (condition) {
        modifierBlock()
    } else {
        Modifier
    }
)
