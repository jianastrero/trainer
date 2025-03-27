package dev.jianastrero.trainer.di

import dev.jianastrero.trainer.ui.page.details.PokemonDetailsViewModel
import dev.jianastrero.trainer.ui.page.home.HomeViewModel
import dev.jianastrero.trainer.ui.page.main.MainViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { MainViewModel(get()) }
    factory { PokemonDetailsViewModel(get()) }
    factory { HomeViewModel(get(), get(), get()) }
}
