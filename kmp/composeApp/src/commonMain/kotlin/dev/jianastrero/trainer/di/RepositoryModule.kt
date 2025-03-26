package dev.jianastrero.trainer.di

import dev.jianastrero.trainer.data.repository.ConfigRepositoryImpl
import dev.jianastrero.trainer.data.repository.PokeApiRepositoryImpl
import dev.jianastrero.trainer.domain.repository.ConfigRepository
import dev.jianastrero.trainer.domain.repository.PokeApiRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModule = module {
    single<PokeApiRepository> { PokeApiRepositoryImpl(get(named<Remote>())) }
    single<ConfigRepository> { ConfigRepositoryImpl(get()) }
}
