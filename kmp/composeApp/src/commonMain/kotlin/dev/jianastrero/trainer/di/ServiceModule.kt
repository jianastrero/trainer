package dev.jianastrero.trainer.di

import dev.jianastrero.trainer.data.service.PokeApiService
import org.koin.core.qualifier.named
import org.koin.dsl.module

val serviceModule = module {
    single { PokeApiService(get(named<PokeApi>())) }
}
