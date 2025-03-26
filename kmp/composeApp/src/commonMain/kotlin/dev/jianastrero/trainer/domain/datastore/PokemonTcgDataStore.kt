package dev.jianastrero.trainer.domain.datastore

import dev.jianastrero.trainer.domain.model.pokemontcg.response.PokemonTcgPaginatedResponse
import dev.jianastrero.trainer.domain.model.pokemontcg.response.card.PokemonCard

interface PokemonTcgDataStore {
    suspend fun getPokemonDetails(name: String): PokemonTcgPaginatedResponse<PokemonCard>
}
