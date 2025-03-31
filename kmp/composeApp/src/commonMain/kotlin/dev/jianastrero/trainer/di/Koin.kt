package dev.jianastrero.trainer.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

fun initKoin(appDeclaration: (KoinApplication.() -> Unit)? = null) {
    startKoin {
        modules(
            preferenceModule,
            remoteModule,
            roomModule,
            dataStoreModule,
            ktorModule,
            repositoryModule,
            useCaseModule,
            viewModelModule
        )
        appDeclaration?.invoke(this)
        this.createEagerInstances()
    }
}
