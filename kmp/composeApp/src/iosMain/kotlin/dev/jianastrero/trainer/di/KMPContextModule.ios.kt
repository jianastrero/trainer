package dev.jianastrero.trainer.di

import dev.jianastrero.trainer.platform.KMPContext
import org.koin.core.module.Module
import org.koin.dsl.module
import platform.darwin.NSObject

actual val kmpContextModule: Module = module {
    single<KMPContext> { NSObject() }
}
