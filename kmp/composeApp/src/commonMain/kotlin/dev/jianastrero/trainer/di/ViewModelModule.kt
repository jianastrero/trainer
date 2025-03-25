package dev.jianastrero.trainer.di

import dev.jianastrero.trainer.ui.page.home.HomeViewModel
import dev.jianastrero.trainer.ui.page.main.MainViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { MainViewModel() }
    factory { HomeViewModel() }
}
