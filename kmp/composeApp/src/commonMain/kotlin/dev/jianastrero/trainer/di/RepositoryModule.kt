package dev.jianastrero.trainer.di

import dev.jianastrero.trainer.data.repository.ConfigRepositoryImpl
import dev.jianastrero.trainer.data.repository.LikedPokemonRepositoryImpl
import dev.jianastrero.trainer.data.repository.PokeApiRepositoryImpl
import dev.jianastrero.trainer.domain.repository.ConfigRepository
import dev.jianastrero.trainer.domain.repository.LikedPokemonRepository
import dev.jianastrero.trainer.domain.repository.PokeApiRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ConfigRepository> { ConfigRepositoryImpl(get()) }
    single<PokeApiRepository> { PokeApiRepositoryImpl(get(), get(), get(), get()) }
    single<LikedPokemonRepository> { LikedPokemonRepositoryImpl(get()) }
}
