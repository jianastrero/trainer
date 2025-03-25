package dev.jianastrero.trainer.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun trainerTypography(): Typography = Typography(
    subtitle1 = TextStyle(
        color = MaterialTheme.colors.onBackground,
        fontSize = 14.sp,
        fontWeight = FontWeight.Thin,
        lineHeight = 14.sp,
        textAlign = TextAlign.Center
    ),
    body1 = TextStyle(
        color = MaterialTheme.colors.onBackground,
        fontSize = 16.sp,
        fontWeight = FontWeight.Light,
        lineHeight = 16.sp,
        textAlign = TextAlign.Center
    ),
    button = TextStyle(
        color = Primary,
        fontSize = 24.sp,
        fontWeight = FontWeight.Black,
        lineHeight = 24.sp,
        textAlign = TextAlign.Center
    ),
)
