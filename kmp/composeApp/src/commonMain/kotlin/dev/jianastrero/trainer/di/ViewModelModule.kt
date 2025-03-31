package dev.jianastrero.trainer.di

import dev.jianastrero.trainer.ui.page.details.PokemonDetailsViewModel
import dev.jianastrero.trainer.ui.page.home.HomeViewModel
import dev.jianastrero.trainer.ui.page.main.MainViewModel
import dev.jianastrero.trainer.ui.page.matches.MatchesViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get(), get(), get(), get()) }
    viewModel { MainViewModel(get()) }
    viewModel { PokemonDetailsViewModel(get(), get()) }
    viewModel { MatchesViewModel(get(), get(), get()) }
}
