package dev.jianastrero.trainer.di

import dev.jianastrero.trainer.data.database.getTrainerDatabase
import org.koin.core.module.Module
import org.koin.dsl.module
import platform.darwin.NSObject

actual val roomModule: Module = module(true) {
    single { getTrainerDatabase(NSObject()) }
}
