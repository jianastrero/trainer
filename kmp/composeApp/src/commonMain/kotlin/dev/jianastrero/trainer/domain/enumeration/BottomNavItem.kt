package dev.jianastrero.trainer.domain.enumeration

import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import trainer.composeapp.generated.resources.Res
import trainer.composeapp.generated.resources.ic_home_active
import trainer.composeapp.generated.resources.ic_home_inactive
import trainer.composeapp.generated.resources.ic_love_active
import trainer.composeapp.generated.resources.ic_love_inactive
import trainer.composeapp.generated.resources.matches
import trainer.composeapp.generated.resources.swipe

enum class BottomNavItem(
    val label: StringResource,
    val activeIcon: DrawableResource,
    val inactiveIcon: DrawableResource
) {
    Swipe(
        label = Res.string.swipe,
        activeIcon = Res.drawable.ic_home_active,
        inactiveIcon = Res.drawable.ic_home_inactive
    ),
    Matches(
        label = Res.string.matches,
        activeIcon = Res.drawable.ic_love_active,
        inactiveIcon = Res.drawable.ic_love_inactive
    );

    companion object {
        val navItems = arrayOf(Swipe, Matches)
    }
}
