package dev.jianastrero.trainer.di

import dev.jianastrero.trainer.data.usecase.GetPokemonsUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetPokemonsUseCase(get()) }
}
