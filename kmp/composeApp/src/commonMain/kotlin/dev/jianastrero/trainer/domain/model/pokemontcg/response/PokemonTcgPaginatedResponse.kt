package dev.jianastrero.trainer.domain.model.pokemontcg.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonTcgPaginatedResponse<T>(
    @SerialName("count") val count: Int,
    @SerialName("data") val result: List<T>,
    @SerialName("page") val page: Int,
    @SerialName("pageSize") val pageSize: Int,
    @SerialName("totalCount") val totalCount: Int
)
