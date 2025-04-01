package dev.jianastrero.trainer.di

import dev.jianastrero.trainer.data.database.TrainerDatabase
import dev.jianastrero.trainer.data.datastore.ConfigDataStoreImpl
import dev.jianastrero.trainer.data.datastore.LikedPokemonDataStore
import dev.jianastrero.trainer.data.datastore.PokemonCardDataStore
import dev.jianastrero.trainer.data.datastore.PokemonDataStore
import dev.jianastrero.trainer.domain.datastore.ConfigDataStore
import org.koin.dsl.module

val dataStoreModule = module(true) {
    single<ConfigDataStore> { ConfigDataStoreImpl(get()) }
    single<PokemonDataStore> { get<TrainerDatabase>().pokemonDataStore() }
    single<PokemonCardDataStore> { get<TrainerDatabase>().pokemonCardDataStore() }
    single<LikedPokemonDataStore> { get<TrainerDatabase>().likedPokemonDataStore() }
}
