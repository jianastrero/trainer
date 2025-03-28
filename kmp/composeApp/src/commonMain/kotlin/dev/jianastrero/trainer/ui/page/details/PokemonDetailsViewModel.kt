package dev.jianastrero.trainer.ui.page.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.jianastrero.trainer.data.usecase.GetPokemonCardsUseCase
import dev.jianastrero.trainer.data.usecase.GetPokemonSpeciesUseCase
import dev.jianastrero.trainer.data.usecase.GetPokemonUseCase
import dev.jianastrero.trainer.data.usecase.SetDarkModeUseCase
import dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon.Pokemon
import dev.jianastrero.trainer.domain.model.pokemontcg.response.card.PokemonCard
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PokemonDetailsViewModel(
    private val setDarkModeUseCase: SetDarkModeUseCase,
    private val getPokemonCardsUseCase: GetPokemonCardsUseCase,
    private val getPokemonUseCase: GetPokemonUseCase,
    private val getPokemonSpeciesUseCase: GetPokemonSpeciesUseCase
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
                fetchPokemonSpecies(pokemonId)
            }
        }
    }

    private suspend fun fetchPokemon(id: String): Pokemon? {
        return runCatching {
            val pokemon = getPokemonUseCase(id)
            _state.emit(state.value.copy(pokemon = pokemon))
            pokemon
        }.onFailure {
            it.printStackTrace()
        }.getOrNull()
    }

    private suspend fun fetchPokemonCards(pokemonName: String) {
        runCatching {
            val allCards = mutableListOf<PokemonCard>()
            while (getPokemonCardsUseCase.hasNext()) {
                allCards += getPokemonCardsUseCase(pokemonName)
            }
            _state.emit(state.value.copy(pokemonCards = allCards))
        }.onFailure {
            it.printStackTrace()
        }
    }

    private suspend fun fetchPokemonSpecies(id: String) {
        runCatching {
            val species = getPokemonSpeciesUseCase(id)
            _state.emit(state.value.copy(pokemonSpecies = species))
        }.onFailure {
            it.printStackTrace()
        }
    }

}
