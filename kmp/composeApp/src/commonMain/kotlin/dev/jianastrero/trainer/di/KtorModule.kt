package dev.jianastrero.trainer.di

import dev.jianastrero.trainer.data.ktor.KtorClient
import org.koin.core.qualifier.named
import org.koin.dsl.module

sealed interface PokeApi
sealed interface PokemonTcgApi

private data object KtorTokens {
    const val POKE_API = "https://pokeapi.co/api/v2"
    const val POKEMON_TCG_API = "https://api.pokemontcg.io/v2"
}

val KtorModule = module {
    single(qualifier = named<PokeApi>()) { KtorClient(KtorTokens.POKE_API) }
    single(qualifier = named<PokemonTcgApi>()) { KtorClient(KtorTokens.POKEMON_TCG_API) }
}
