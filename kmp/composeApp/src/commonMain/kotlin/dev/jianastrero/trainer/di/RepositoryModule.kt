package dev.jianastrero.trainer.di

import dev.jianastrero.trainer.data.repository.ConfigRepositoryImpl
import dev.jianastrero.trainer.data.repository.PokeApiRepositoryImpl
import dev.jianastrero.trainer.data.repository.PokemonTcgRepositoryImpl
import dev.jianastrero.trainer.domain.repository.ConfigRepository
import dev.jianastrero.trainer.domain.repository.PokeApiRepository
import dev.jianastrero.trainer.domain.repository.PokemonTcgRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModule = module {
    single<ConfigRepository> { ConfigRepositoryImpl(get()) }
    single<PokeApiRepository> { PokeApiRepositoryImpl(get(named<Remote>())) }
    single<PokemonTcgRepository> { PokemonTcgRepositoryImpl(get(named<Remote>())) }
}
