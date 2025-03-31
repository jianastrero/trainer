package dev.jianastrero.trainer.di

import dev.jianastrero.trainer.platform.KMPPreference
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module

actual val preferenceModule: Module = module(true) {
    single<KMPPreference> { KMPPreference(androidApplication()) }
}
