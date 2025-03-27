package dev.jianastrero.trainer.domain.screen

import kotlinx.serialization.Serializable

interface Screen {
    @Serializable
    data object Main : Screen

    @Serializable
    data class PokemonDetail(val id: String) : Screen

    interface BottomNav {
        @Serializable
        data object Swipe : BottomNav

        @Serializable
        data object Matches : BottomNav
    }
}
