package dev.jianastrero.trainer.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon.Pokemon
import dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon.PokemonType
import dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon.PokemonTypeName
import dev.jianastrero.trainer.ui.molecule.PokemonTypePills
import dev.jianastrero.trainer.ui.theme.Light
import dev.jianastrero.trainer.ui.theme.TrainerTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import dev.jianastrero.trainer.domain.enumeration.PokemonType as PokemonTypeEnum

@Composable
fun PokemonTitleBar(
    pokemon: Pokemon,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        Text(
            text = pokemon.name,
            color = Light,
            fontSize = 48.sp,
            fontWeight = FontWeight.Black,
        )
        PokemonTypePills(
            pokemonTypes = pokemon.types.map { it.type.name },
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}

@Preview
@Composable
private fun PreviewPokemonTitleBar() {
    TrainerTheme {
        PokemonTitleBar(
            pokemon = Pokemon.Sample.copy(
                name = "Bulbasaur",
                types = listOf(
                    PokemonType(
                        0,
                        PokemonTypeName(PokemonTypeEnum.Grass)
                    ),
                    PokemonType(
                        0,
                        PokemonTypeName(PokemonTypeEnum.Poison)
                    ),
                )
            ),
            modifier = Modifier
                .background(Light)
                .background(PokemonTypeEnum.Grass.color.copy(alpha = 0.72f))
                .padding(24.dp)
        )
    }
}
