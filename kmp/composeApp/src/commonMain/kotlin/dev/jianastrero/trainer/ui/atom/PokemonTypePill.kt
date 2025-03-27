package dev.jianastrero.trainer.ui.atom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.jianastrero.trainer.domain.enumeration.PokemonType
import dev.jianastrero.trainer.ui.theme.Light
import dev.jianastrero.trainer.ui.theme.TrainerTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun PokemonTypePill(
    pokemonType: PokemonType,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(
                color = Light.copy(alpha = 0.72f),
                shape = MaterialTheme.shapes.large
            )
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        pokemonType.icon?.let { icon ->
            Icon(
                painter = painterResource(icon),
                contentDescription = pokemonType.name,
                tint = pokemonType.color,
                modifier = Modifier.size(16.dp)
            )
        }
        Text(
            text = pokemonType.name,
            color = pokemonType.color,
            fontSize = 14.sp,
            fontWeight = FontWeight.Black,
            lineHeight = 10.sp
        )
    }
}

@Preview
@Composable
private fun PreviewPokemonTypePill() {
    LazyColumn {
        items(PokemonType.entries) { type ->
            TrainerTheme(isDarkMode = false) {
                Column {
                    Box(
                        modifier = Modifier
                            .background(type.color)
                            .padding(24.dp)
                    ) {
                        PokemonTypePill(
                            pokemonType = type
                        )
                    }
                    Box(
                        modifier = Modifier
                            .background(MaterialTheme.colors.background)
                            .background(type.color.copy(alpha = 0.84f))
                            .padding(24.dp)
                    ) {
                        PokemonTypePill(
                            pokemonType = type
                        )
                    }
                }
            }
        }
    }
}
