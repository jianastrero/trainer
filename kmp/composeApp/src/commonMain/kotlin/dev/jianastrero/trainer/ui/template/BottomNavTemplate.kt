package dev.jianastrero.trainer.ui.template

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.jianastrero.trainer.domain.enumeration.BottomNavItem
import dev.jianastrero.trainer.ui.organism.BottomNav
import dev.jianastrero.trainer.ui.theme.TrainerTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun BottomNavTemplate(
    selected: BottomNavItem,
    onSelectBottomNavItem: (BottomNavItem) -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier = modifier) {
        Box(modifier = Modifier.weight(1f)) {
            content()
        }
        BottomNav(
            selected = selected,
            onSelectBottomNavItem = onSelectBottomNavItem,
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
        )
    }
}

@Preview
@Composable
private fun BottomNavTemplatePreview() {
    TrainerTheme {
        BottomNavTemplate(
            selected = BottomNavItem.Swipe,
            onSelectBottomNavItem = {},
            modifier = Modifier.fillMaxSize()
        ) {}
    }
}
