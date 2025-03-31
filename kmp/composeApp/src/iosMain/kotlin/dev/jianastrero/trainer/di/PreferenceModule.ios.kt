package dev.jianastrero.trainer.di

import dev.jianastrero.trainer.platform.KMPPreference
import org.koin.core.module.Module
import org.koin.dsl.module
import platform.darwin.NSObject

actual val preferenceModule: Module = module(true) {
    single<KMPPreference> { KMPPreference(NSObject()) }
}
