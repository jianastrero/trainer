package dev.jianastrero.trainer.di

import dev.jianastrero.trainer.data.datastore.ConfigDataStoreLocal
import dev.jianastrero.trainer.data.datastore.PokeApiDataStoreRemote
import dev.jianastrero.trainer.domain.datastore.ConfigDataStore
import dev.jianastrero.trainer.domain.datastore.PokeApiDataStore
import org.koin.core.qualifier.named
import org.koin.dsl.module

sealed interface Local
sealed interface Remote

val dataStoreModule = module {
    single<ConfigDataStore> { ConfigDataStoreLocal(get()) }
    single<PokeApiDataStore>(named<Remote>()) { PokeApiDataStoreRemote(get()) }
}
