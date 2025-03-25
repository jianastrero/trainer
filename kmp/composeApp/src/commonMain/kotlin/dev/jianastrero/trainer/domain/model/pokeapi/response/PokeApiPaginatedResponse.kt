package dev.jianastrero.trainer.domain.model.pokeapi.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokeApiPaginatedResponse<T>(
    @SerialName("count") val count: Int?,
    @SerialName("next") val next: String?,
    @SerialName("previous") val previous: String?,
    @SerialName("results") val results: List<T>
) {
    class NextPage(
        val offset: Int,
        val limit: Int
    )

    val nextPage: NextPage?
        get() {
            return runCatching {
                val url = next ?: return null
                val query = url.split("?").last()
                val params = query.split("&")
                val offset = params.first { it.startsWith("offset") }.split("=").last().toInt()
                val limit = params.first { it.startsWith("limit") }.split("=").last().toInt()
                return NextPage(offset = offset, limit = limit)
            }.getOrNull()
        }
}
