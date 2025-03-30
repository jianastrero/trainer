package dev.jianastrero.trainer.domain.nav

import kotlinx.serialization.Serializable

sealed interface NavDirection {

    data object Back : NavDirection

    sealed interface Screen : NavDirection {
        @Serializable
        data object Main : Screen

        @Serializable
        data class PokemonDetail(val id: String) : Screen
    }

    @Serializable
    sealed interface BottomNav : NavDirection {

        @Serializable
        data object Swipe : BottomNav

        @Serializable
        data object Matches : BottomNav
    }
}
