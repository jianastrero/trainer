package dev.jianastrero.trainer.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

private val Primary = Color(0xFFE53935)
private val Light = Color(0xFFECEFF1)
private val Dark = Color(0xFF2C3E50)
private val Error = Color(0xFFB00020)

val TrainerLightColors = Colors(
    primary = Primary,
    primaryVariant = Primary,
    secondary = Primary,
    secondaryVariant = Primary,
    background = Light,
    surface = Light,
    error = Error,
    onPrimary = Light,
    onSecondary = Light,
    onBackground = Dark,
    onSurface = Dark,
    onError = Light,
    isLight = true
)

val TrainerDarkColors = Colors(
    primary = Primary,
    primaryVariant = Primary,
    secondary = Primary,
    secondaryVariant = Primary,
    background = Dark,
    surface = Dark,
    error = Error,
    onPrimary = Light,
    onSecondary = Light,
    onBackground = Light,
    onSurface = Light,
    onError = Dark,
    isLight = false
)
