package dev.jianastrero.trainer.di

import dev.jianastrero.trainer.platform.KMPPreference
import org.koin.dsl.module

val preferenceModule = module {
    single { KMPPreference(get()) }
}
