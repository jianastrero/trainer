package dev.jianastrero.trainer.ui.page.matches

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.jianastrero.trainer.data.usecase.DislikePokemonUseCase
import dev.jianastrero.trainer.data.usecase.GetLikedPokemonsUseCase
import dev.jianastrero.trainer.data.usecase.SetDarkModeUseCase
import dev.jianastrero.trainer.domain.entity.Pokemon
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MatchesViewModel(
    private val setDarkModeUseCase: SetDarkModeUseCase,
    private val getLikedPokemonsUseCase: GetLikedPokemonsUseCase,
    private val dislikePokemonUseCase: DislikePokemonUseCase,
) : ViewModel() {

    private val _likedPokemons = MutableStateFlow(emptyList<Pokemon>())
    val likedPokemons = _likedPokemons.asStateFlow()

    fun setDarkMode(isDarkMode: Boolean) {
        viewModelScope.launch {
            runCatching {
                setDarkModeUseCase(isDarkMode)
            }
        }
    }

    fun getLikedPokemons() {
        viewModelScope.launch {
            suspendedGetLikedPokemons()
        }
    }

    fun dislikePokemon(pokemon: Pokemon) {
        viewModelScope.launch {
            runCatching {
                dislikePokemonUseCase(pokemon.id)
                suspendedGetLikedPokemons()
            }
        }
    }

    private suspend fun suspendedGetLikedPokemons() {
        runCatching {
            val list = getLikedPokemonsUseCase()
            _likedPokemons.emit(list)
        }
    }

}
