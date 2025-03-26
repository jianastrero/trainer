package dev.jianastrero.trainer.di

import dev.jianastrero.trainer.platform.KMPPreference
import org.koin.core.module.Module
import org.koin.dsl.module
import platform.darwin.NSObject

actual val preferenceModule: Module
    get() = module {
        single { KMPPreference(NSObject()) }
    }
