package dev.jianastrero.trainer.ui.page.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.jianastrero.trainer.data.usecase.GetPokemonUseCase
import dev.jianastrero.trainer.data.usecase.SetDarkModeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PokemonDetailsViewModel(
    private val setDarkModeUseCase: SetDarkModeUseCase,
    private val getPokemonUseCase: GetPokemonUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(PokemonDetailsState())
    val state = _state.asStateFlow()

    fun setDarkMode(isDarkMode: Boolean) {
        viewModelScope.launch {
            setDarkModeUseCase(isDarkMode)
        }
    }

    fun getPokemon(pokemonId: String) {
        viewModelScope.launch {
            runCatching {
                getPokemonUseCase(pokemonId).also { pokemon ->
                    _state.emit(state.value.copy(pokemon = pokemon.pokemon, pokemonCards = pokemon.cards))
                }
            }.onFailure {
                it.printStackTrace()
            }
        }
    }

}
