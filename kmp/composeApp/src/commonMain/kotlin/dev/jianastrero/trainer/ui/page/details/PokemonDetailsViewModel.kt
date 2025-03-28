package dev.jianastrero.trainer.ui.page.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.jianastrero.trainer.data.usecase.GetPokemonCardsUseCase
import dev.jianastrero.trainer.data.usecase.GetPokemonUseCase
import dev.jianastrero.trainer.domain.model.pokemontcg.response.card.PokemonCard
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PokemonDetailsViewModel(
    private val getPokemonCardsUseCase: GetPokemonCardsUseCase,
    private val getPokemonUseCase: GetPokemonUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(PokemonDetailsState())
    val state = _state.asStateFlow()

    fun getPokemon(pokemonId: String) {
        viewModelScope.launch {
            runCatching {
                val pokemon = getPokemonUseCase(pokemonId)
                val allCards = mutableListOf<PokemonCard>()

                while (getPokemonCardsUseCase.hasNext()) {
                    allCards += getPokemonCardsUseCase(pokemon.name)
                }

                _state.value = state.value.copy(
                    pokemon = pokemon,
                    pokemonCards = allCards
                )
            }
        }
    }

}
