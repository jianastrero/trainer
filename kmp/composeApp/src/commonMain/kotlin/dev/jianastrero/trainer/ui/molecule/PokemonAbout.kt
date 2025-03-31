package dev.jianastrero.trainer.ui.molecule

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.jianastrero.trainer.domain.entity.Pokemon
import dev.jianastrero.trainer.domain.ext.capitalized
import dev.jianastrero.trainer.ui.atom.LabelAndValue
import dev.jianastrero.trainer.ui.theme.TrainerTheme

@Composable
fun PokemonAbout(
    pokemon: Pokemon?,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        Text(
            text = "About",
            color = TrainerTheme.colors.onBackground.copy(alpha = 0.4f),
            fontSize = 18.sp,
            fontWeight = FontWeight.Black,
            textAlign = TextAlign.Start,
            style = TrainerTheme.typography.body1,
            modifier = Modifier.fillMaxWidth()
        )
        LabelAndValue(
            label = "Species",
            value = pokemon?.species,
            modifier = Modifier.fillMaxWidth()
        )
        LabelAndValue(
            label = "Height",
            value = pokemon?.let { "${it.heightCm} cm" },
            modifier = Modifier.fillMaxWidth()
        )
        LabelAndValue(
            label = "Weight",
            value = pokemon?.let { "${it.weightKg} kg" },
            modifier = Modifier.fillMaxWidth()
        )
        LabelAndValue(
            label = "Abilities",
            value = pokemon?.abilities?.joinToString(", ") { it.capitalized },
            modifier = Modifier.fillMaxWidth()
        )
    }
}
