package dev.jianastrero.trainer.ui.organism

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon.PokemonResponse
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
private fun PokemonDetails(
    pokemon: PokemonResponse,
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
            pokemon = PokemonResponse.Sample,
            modifier = Modifier
        )
    }
}
