package dev.jianastrero.trainer.ui.organism

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.jianastrero.trainer.domain.enumeration.BottomNavItem
import dev.jianastrero.trainer.ui.molecule.BottomNavItem
import dev.jianastrero.trainer.ui.theme.TrainerTheme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun BottomNav(
    selected: BottomNavItem,
    onSelectBottomNavItem: (BottomNavItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        BottomNavItem.navItems.forEach { bottomNav ->
            BottomNavItem(
                isActive = bottomNav == selected,
                label = stringResource(bottomNav.label),
                activeIcon = bottomNav.activeIcon,
                inactiveIcon = bottomNav.inactiveIcon,
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clickable {
                        onSelectBottomNavItem(bottomNav)
                    }
                    .padding(4.dp)
            )
        }
    }
}

@Preview
@Composable
private fun BottomNavPreview() {
    TrainerTheme {
        BottomNav(
            selected = BottomNavItem.Home,
            onSelectBottomNavItem = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}
