package dev.jianastrero.trainer.di

import dev.jianastrero.trainer.data.database.getTrainerDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module

actual val roomModule: Module = module {
    single { getTrainerDatabase(androidApplication()) }
}
