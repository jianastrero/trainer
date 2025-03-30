package dev.jianastrero.trainer.di

import dev.jianastrero.trainer.platform.KMPContext
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module

actual val kmpContextModule: Module = module {
    single<KMPContext> { androidApplication() }
}
