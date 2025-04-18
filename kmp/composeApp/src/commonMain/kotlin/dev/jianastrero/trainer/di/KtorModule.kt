package dev.jianastrero.trainer.di

import dev.jianastrero.trainer.data.ktor.KtorClient
import org.koin.core.qualifier.named
import org.koin.dsl.module

sealed interface PokeApi
sealed interface PokemonTcgApi

private data object KtorTokens {
    const val POKE_API = "https://pokeapi.co"
    const val POKEMON_TCG = "https://api.pokemontcg.io"
}

val ktorModule = module(true) {
    single(named<PokeApi>()) { KtorClient(KtorTokens.POKE_API) }
    single(named<PokemonTcgApi>()) { KtorClient(KtorTokens.POKEMON_TCG) }
}
