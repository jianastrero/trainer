package dev.jianastrero.trainer.domain.model.pokeapi.response.species


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonSpecies(
    @SerialName("base_happiness") val baseHappiness: Int,
    @SerialName("capture_rate") val captureRate: Int,
    @SerialName("flavor_text_entries") val flavorTextEntries: List<PokemonSpeciesFlavorTextEntry>,
    @SerialName("genera") val genera: List<PokemonSpeciesGenera>,
    @SerialName("growth_rate") val growthRate: PokemonSpeciesGrowthRate,
    @SerialName("habitat") val habitat: PokemonSpeciesHabitat,
    @SerialName("id") val id: Int,
    @SerialName("is_baby") val isBaby: Boolean,
    @SerialName("is_legendary") val isLegendary: Boolean,
    @SerialName("is_mythical") val isMythical: Boolean,
    @SerialName("name") val name: String,
    @SerialName("order") val order: Int,
    @SerialName("pal_park_encounters") val palParkEncounters: List<PokemonSpeciesPalParkEncounter>,
) {
    companion object {
        val Sample = PokemonSpecies(
            baseHappiness = 0,
            captureRate = 0,
            flavorTextEntries = emptyList(),
            genera = emptyList(),
            growthRate = PokemonSpeciesGrowthRate("sample", "sample"),
            habitat = PokemonSpeciesHabitat("sample", "sample"),
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
