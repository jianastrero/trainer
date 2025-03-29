package dev.jianastrero.trainer.ui.page.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.jianastrero.trainer.data.usecase.GetNextPokemonCardsUseCase
import dev.jianastrero.trainer.data.usecase.GetPokemonUseCase
import dev.jianastrero.trainer.data.usecase.SetDarkModeUseCase
import dev.jianastrero.trainer.domain.entity.Pokemon
import dev.jianastrero.trainer.domain.entity.PokemonCard
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PokemonDetailsViewModel(
    private val setDarkModeUseCase: SetDarkModeUseCase,
    private val getPokemonCardsUseCase: GetNextPokemonCardsUseCase,
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
                val pokemon = fetchPokemon(pokemonId) ?: return@launch
                fetchPokemonCards(pokemon.name)
            }
        }
    }

    private suspend fun fetchPokemon(pokemonId: String): Pokemon? {
        return runCatching {
            getPokemonUseCase(pokemonId).also { pokemon ->
                _state.emit(state.value.copy(pokemon = pokemon))
            }
        }.onFailure {
            it.printStackTrace()
        }.getOrNull()
    }

    private suspend fun fetchPokemonCards(pokemonName: String) {
        runCatching {
            val allCards = mutableListOf<PokemonCard>()
            while (getPokemonCardsUseCase.hasNext) {
                allCards += getPokemonCardsUseCase(pokemonName)
            }
            _state.emit(state.value.copy(pokemonCards = allCards))
        }.onFailure {
            it.printStackTrace()
        }
    }

}
