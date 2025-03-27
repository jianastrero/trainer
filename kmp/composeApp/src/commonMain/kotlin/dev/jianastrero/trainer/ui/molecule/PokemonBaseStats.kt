package dev.jianastrero.trainer.ui.molecule

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon.PokemonStat
import dev.jianastrero.trainer.domain.model.pokeapi.response.pokemon.PokemonStatName
import dev.jianastrero.trainer.ui.atom.LabelAndValue
import org.jetbrains.compose.ui.tooling.preview.Preview
import dev.jianastrero.trainer.domain.enumeration.PokemonStat as PokemonStatEnum

@Composable
fun PokemonBaseStats(
    stats: List<PokemonStat>,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        Text(
            text = "Base Stats",
            color = MaterialTheme.colors.onBackground.copy(alpha = 0.4f),
            fontSize = 18.sp,
            fontWeight = FontWeight.Black,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )
        PokemonStatEnum.labels.forEach {
            LabelAndValue(
                label = it.label,
                value = stats.firstOrNull { stat -> stat.stat.name == it }?.baseStat?.toString() ?: "Unknown",
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
private fun PreviewPokemonBaseStats() {
    PokemonBaseStats(
        stats = listOf(
            PokemonStat(
                baseStat = 50,
                effort = 0,
                stat = PokemonStatName(
                    name = PokemonStatEnum.HP,
                    url = "https://pokeapi.co/api/v2/stat/1/"
                )
            ),
            PokemonStat(
                baseStat = 50,
                effort = 0,
                stat = PokemonStatName(
                    name = PokemonStatEnum.Attack,
                    url = "https://pokeapi.co/api/v2/stat/2/"
                )
            ),
            PokemonStat(
                baseStat = 50,
                effort = 0,
                stat = PokemonStatName(
                    name = PokemonStatEnum.Defense,
                    url = "https://pokeapi.co/api/v2/stat/3/"
                )
            ),
            PokemonStat(
                baseStat = 50,
                effort = 0,
                stat = PokemonStatName(
                    name = PokemonStatEnum.SpecialAttack,
                    url = "https://pokeapi.co/api/v2/stat/4/"
                )
            ),
            PokemonStat(
                baseStat = 50,
                effort = 0,
                stat = PokemonStatName(
                    name = PokemonStatEnum.SpecialDefense,
                    url = "https://pokeapi.co/api/v2/stat/5/"
                )
            ),
            PokemonStat(
                baseStat = 50,
                effort = 0,
                stat = PokemonStatName(
                    name = PokemonStatEnum.Speed,
                    url = "https://pokeapi.co/api/v2/stat/6/"
                )
            )
        ),
        modifier = Modifier
    )
}
