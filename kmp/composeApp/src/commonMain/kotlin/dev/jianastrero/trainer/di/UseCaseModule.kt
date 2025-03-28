package dev.jianastrero.trainer.di

import dev.jianastrero.trainer.data.usecase.GetPokemonCardsUseCase
import dev.jianastrero.trainer.data.usecase.GetPokemonSpeciesUseCase
import dev.jianastrero.trainer.data.usecase.GetPokemonUseCase
import dev.jianastrero.trainer.data.usecase.GetPokemonsUseCase
import dev.jianastrero.trainer.data.usecase.IsDarkModeUseCase
import dev.jianastrero.trainer.data.usecase.SetDarkModeUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetPokemonCardsUseCase(get()) }
    factory { GetPokemonSpeciesUseCase(get()) }
    factory { GetPokemonsUseCase(get()) }
    factory { GetPokemonUseCase(get()) }
    factory { IsDarkModeUseCase(get()) }
    factory { SetDarkModeUseCase(get()) }
}
