package dev.jianastrero.trainer.ui.page.home

import androidx.lifecycle.ViewModel
import dev.jianastrero.trainer.data.usecase.GetPokemonsUseCase
import dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val getPokemonsUseCase: GetPokemonsUseCase
) : ViewModel() {

    private val _pokemons = MutableStateFlow(emptyList<Pokemon>())
    val pokemons = _pokemons.asStateFlow()

    suspend fun getNextPokemons() = withContext(Dispatchers.IO) {
        runCatching {
            val response = getPokemonsUseCase()
            _pokemons.emit(_pokemons.value + response)
        }.onFailure { throwable ->
            throwable.printStackTrace()
        }
    }

}
