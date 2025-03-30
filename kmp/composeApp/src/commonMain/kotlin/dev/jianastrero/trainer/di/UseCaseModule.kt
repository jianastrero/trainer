package dev.jianastrero.trainer.di

import dev.jianastrero.trainer.data.usecase.DislikePokemonUseCase
import dev.jianastrero.trainer.data.usecase.GetLikedPokemonsUseCase
import dev.jianastrero.trainer.data.usecase.GetNextPokemonsUseCase
import dev.jianastrero.trainer.data.usecase.GetPokemonUseCase
import dev.jianastrero.trainer.data.usecase.IsDarkModeUseCase
import dev.jianastrero.trainer.data.usecase.LikePokemonUseCase
import dev.jianastrero.trainer.data.usecase.SetDarkModeUseCase
import dev.jianastrero.trainer.data.usecase.SetLastSeenPokemonIdUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetNextPokemonsUseCase(get()) }
    factory { GetPokemonUseCase(get()) }
    factory { IsDarkModeUseCase(get()) }
    factory { SetDarkModeUseCase(get()) }
    factory { LikePokemonUseCase(get()) }
    factory { DislikePokemonUseCase(get()) }
    factory { GetLikedPokemonsUseCase(get()) }
    factory { SetLastSeenPokemonIdUseCase(get()) }
}
