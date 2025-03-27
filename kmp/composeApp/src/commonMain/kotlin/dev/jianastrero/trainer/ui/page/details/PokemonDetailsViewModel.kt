package dev.jianastrero.trainer.ui.page.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.jianastrero.trainer.data.usecase.GetPokemonUseCase
import dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon.Pokemon
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PokemonDetailsViewModel(
    private val getPokemonUseCase: GetPokemonUseCase,
) : ViewModel() {

    private val _pokemon = MutableStateFlow<Pokemon?>(null)
    val pokemon = _pokemon.asStateFlow()

    fun getPokemon(pokemonId: String) {
        viewModelScope.launch {
            runCatching {
                val pokemon = getPokemonUseCase(pokemonId)
                _pokemon.emit(pokemon)
            }
        }
    }

}
