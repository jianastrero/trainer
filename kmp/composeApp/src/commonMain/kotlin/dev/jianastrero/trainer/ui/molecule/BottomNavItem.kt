package dev.jianastrero.trainer.ui.molecule

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.jianastrero.trainer.ui.theme.Dark
import dev.jianastrero.trainer.ui.theme.TrainerTheme
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import trainer.composeapp.generated.resources.Res
import trainer.composeapp.generated.resources.ic_home_active
import trainer.composeapp.generated.resources.ic_home_inactive
import trainer.composeapp.generated.resources.swipe

@Composable
fun BottomNavItem(
    isActive: Boolean,
    label: String,
    activeIcon: DrawableResource,
    inactiveIcon: DrawableResource,
    modifier: Modifier = Modifier
) {
    val color = MaterialTheme.colors.onBackground
    val colorAnim by animateColorAsState(
        targetValue = if (isActive) color else color.copy(alpha = 0.6f),
        animationSpec = tween()
    )
    val weightAnim by animateIntAsState(
        targetValue = if (isActive) FontWeight.Bold.weight else FontWeight.Light.weight,
        animationSpec = tween()
    )
    val letterSpacingAnim by animateFloatAsState(
        targetValue = if (isActive) 0f else 2f,
        animationSpec = tween()
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically),
        modifier = modifier
    ) {
        Image(
            painter = painterResource(if (isActive) activeIcon else inactiveIcon),
            contentDescription = label,
            colorFilter = if (isActive) null else ColorFilter.tint(color.copy(alpha = 0.6f)),
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = label,
            color = colorAnim,
            fontWeight = FontWeight(weightAnim),
            letterSpacing = letterSpacingAnim.sp,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Preview
@Composable
private fun BottomNavItemPreview() {
    TrainerTheme(isDarkMode = true) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(12.dp)
        ) {
            BottomNavItem(
                isActive = true,
                label = stringResource(Res.string.swipe),
                activeIcon = Res.drawable.ic_home_active,
                inactiveIcon = Res.drawable.ic_home_inactive,
                modifier = Modifier.size(48.dp)
            )
            BottomNavItem(
                isActive = false,
                label = stringResource(Res.string.swipe),
                activeIcon = Res.drawable.ic_home_active,
                inactiveIcon = Res.drawable.ic_home_inactive,
                modifier = Modifier.size(48.dp)
            )
        }
    }
}
