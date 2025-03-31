package dev.jianastrero.trainer.di

import dev.jianastrero.trainer.data.remote.PokeApiRemote
import dev.jianastrero.trainer.data.remote.PokemonTcgRemote
import org.koin.core.qualifier.named
import org.koin.dsl.module

val remoteModule = module(true) {
    single<PokeApiRemote> { PokeApiRemote(get(named<PokeApi>())) }
    single<PokemonTcgRemote> { PokemonTcgRemote(get(named<PokemonTcgApi>())) }
}
