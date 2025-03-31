package dev.jianastrero.trainer.ui.molecule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.FlowRowOverflow
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.jianastrero.trainer.domain.enumeration.PokemonType
import dev.jianastrero.trainer.ui.atom.PokemonTypePill
import dev.jianastrero.trainer.ui.theme.TrainerTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PokemonTypePills(
    pokemonTypes: List<PokemonType>,
    modifier: Modifier = Modifier
) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
        modifier = modifier
    ) {
        pokemonTypes.forEach {
            PokemonTypePill(pokemonType = it)
        }
    }
}

@Preview
@Composable
private fun PreviewPokemonTypePills() {
    TrainerTheme {
        PokemonTypePills(
            pokemonTypes = PokemonType.entries,
            modifier = Modifier
                .background(TrainerTheme.colors.onBackground)
                .padding(24.dp)
        )
    }
}
