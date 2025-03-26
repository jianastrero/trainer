package dev.jianastrero.trainer.di

import dev.jianastrero.trainer.data.usecase.GetPokemonsUseCase
import dev.jianastrero.trainer.data.usecase.IsDarkModeUseCase
import dev.jianastrero.trainer.data.usecase.SetDarkModeUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetPokemonsUseCase(get()) }
    factory { IsDarkModeUseCase(get()) }
    factory { SetDarkModeUseCase(get()) }
}
