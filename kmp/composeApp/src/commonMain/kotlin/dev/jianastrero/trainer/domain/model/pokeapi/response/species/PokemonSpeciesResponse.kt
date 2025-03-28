package dev.jianastrero.trainer.domain.model.pokeapi.response.species


import dev.jianastrero.trainer.domain.enumeration.Language
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonSpeciesResponse(
    @SerialName("base_happiness") val baseHappiness: Int,
    @SerialName("capture_rate") val captureRate: Int,
    @SerialName("flavor_text_entries") val flavorTextEntries: List<PokemonSpeciesFlavorTextEntryResponse>,
    @SerialName("genera") val genera: List<PokemonSpeciesGeneraResponse>,
    @SerialName("growth_rate") val growthRate: PokemonSpeciesGrowthRateResponse,
    @SerialName("habitat") val habitat: PokemonSpeciesHabitatResponse,
    @SerialName("id") val id: Int,
    @SerialName("is_baby") val isBaby: Boolean,
    @SerialName("is_legendary") val isLegendary: Boolean,
    @SerialName("is_mythical") val isMythical: Boolean,
    @SerialName("name") val name: String,
    @SerialName("order") val order: Int,
    @SerialName("pal_park_encounters") val palParkEncounters: List<PokemonSpeciesPalParkEncounter>,
) {
    companion object {
        val Sample = PokemonSpeciesResponse(
            baseHappiness = 0,
            captureRate = 0,
            flavorTextEntries = emptyList(),
            genera = emptyList(),
            growthRate = PokemonSpeciesGrowthRateResponse("sample", "sample"),
            habitat = PokemonSpeciesHabitatResponse("sample", "sample"),
            id = 0,
            isBaby = false,
            isLegendary = false,
            isMythical = false,
            name = "Sample",
            order = 0,
            palParkEncounters = emptyList()
        )
    }
}

val PokemonSpeciesResponse?.genus: String
    get() = this?.genera
        ?.firstOrNull { it.language.name == Language.English }
        ?.genus
        ?: "Unknown"
