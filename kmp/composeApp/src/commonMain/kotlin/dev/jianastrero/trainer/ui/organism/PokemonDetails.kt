package dev.jianastrero.trainer.ui.organism

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon.Pokemon
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
private fun PokemonDetails(
    pokemon: Pokemon,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        
    }
}

@Preview
@Composable
private fun PreviewPokemonDetails() {
    MaterialTheme {
        PokemonDetails(
            pokemon = Pokemon.Sample,
            modifier = Modifier
        )
    }
}
