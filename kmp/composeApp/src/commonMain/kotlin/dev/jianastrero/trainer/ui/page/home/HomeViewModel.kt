package dev.jianastrero.trainer.ui.page.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.jianastrero.trainer.data.usecase.GetNextPokemonsUseCase
import dev.jianastrero.trainer.data.usecase.LikePokemonUseCase
import dev.jianastrero.trainer.data.usecase.SetDarkModeUseCase
import dev.jianastrero.trainer.data.usecase.SetLastSeenPokemonIdUseCase
import dev.jianastrero.trainer.domain.entity.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val setDarkModeUseCase: SetDarkModeUseCase,
    private val getPokemonsUseCase: GetNextPokemonsUseCase,
    private val likePokemonUseCase: LikePokemonUseCase,
    private val setLastSeenPokemonIdUseCase: SetLastSeenPokemonIdUseCase,
) : ViewModel() {

    private val _pokemons = MutableStateFlow(emptyList<Pokemon>())
    val pokemons = _pokemons.asStateFlow()

    fun setDarkMode(isDarkMode: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                setDarkModeUseCase(isDarkMode)
            }
        }
    }

    suspend fun getNextPokemons() = withContext(Dispatchers.IO) {
        runCatching {
            val response = getPokemonsUseCase()
            _pokemons.emit(_pokemons.value + response)
        }.onFailure { throwable ->
            throwable.printStackTrace()
        }
    }

    fun like(pokemon: Pokemon) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                removePokemon(pokemon)
                pokemons.value.firstOrNull()?.let {
                    setLastSeenPokemonId(it.id)
                }
                likePokemonUseCase(pokemon.id)
            }
        }
    }

    fun dislike(pokemon: Pokemon) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                removePokemon(pokemon)
                pokemons.value.firstOrNull()?.let {
                    setLastSeenPokemonId(it.id)
                }
            }
        }
    }

    private suspend fun removePokemon(pokemon: Pokemon) {
        _pokemons.emit(_pokemons.value - pokemon)
    }

    private suspend fun setLastSeenPokemonId(pokemonId: String) {
        setLastSeenPokemonIdUseCase(pokemonId)
    }

}
