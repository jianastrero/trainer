package dev.jianastrero.trainer.di

import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(ktorModule, serviceModule, repositoryModule, useCaseModule, viewModelModule)
    }
}
