package dev.jianastrero.trainer.di

import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(
            preferenceModule,
            dataStoreModule,
            ktorModule,
            repositoryModule,
            useCaseModule,
            viewModelModule
        )
    }
}
