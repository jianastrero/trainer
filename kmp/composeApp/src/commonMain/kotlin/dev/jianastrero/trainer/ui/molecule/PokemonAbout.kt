package dev.jianastrero.trainer.ui.molecule

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.jianastrero.trainer.domain.enumeration.Language
import dev.jianastrero.trainer.domain.ext.capitalized
import dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon.Pokemon
import dev.jianastrero.trainer.domain.model.pokeapi.response.species.PokemonSpecies
import dev.jianastrero.trainer.ui.atom.LabelAndValue
import dev.jianastrero.trainer.ui.theme.TrainerTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun PokemonAbout(
    pokemon: Pokemon,
    species: PokemonSpecies,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        Text(
            text = "About",
            color = MaterialTheme.colors.onBackground.copy(alpha = 0.4f),
            fontSize = 18.sp,
            fontWeight = FontWeight.Black,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )
        LabelAndValue(
            label = "Species",
            value = species.genera.firstOrNull { it.language.name == Language.English }?.genus ?: "Unknown",
            modifier = Modifier.fillMaxWidth()
        )
        LabelAndValue(
            label = "Height",
            value = "${pokemon.heightCm} cm",
            modifier = Modifier.fillMaxWidth()
        )
        LabelAndValue(
            label = "Weight",
            value = "${pokemon.weightKg} kg",
            modifier = Modifier.fillMaxWidth()
        )
        LabelAndValue(
            label = "Abilities",
            value = pokemon.abilities.joinToString(",") { it.ability.name.capitalized },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
private fun PokemonAboutPreview() {
    TrainerTheme {
        PokemonAbout(
            pokemon = Pokemon.Sample,
            species = PokemonSpecies.Sample,
            modifier = Modifier
        )
    }
}
