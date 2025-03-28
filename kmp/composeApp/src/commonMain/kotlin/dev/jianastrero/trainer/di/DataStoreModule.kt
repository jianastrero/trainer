package dev.jianastrero.trainer.di

import dev.jianastrero.trainer.data.database.TrainerDatabase
import dev.jianastrero.trainer.data.datastore.ConfigDataStore
import dev.jianastrero.trainer.data.datastore.PokemonDataStore
import org.koin.dsl.module

val dataStoreModule = module {
    single<ConfigDataStore> { ConfigDataStore(get()) }
    single<PokemonDataStore> { get<TrainerDatabase>().pokemonDataStore() }
}
