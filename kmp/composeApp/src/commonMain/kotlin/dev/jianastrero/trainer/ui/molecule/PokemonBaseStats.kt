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
import dev.jianastrero.trainer.domain.enumeration.PokemonStat
import dev.jianastrero.trainer.ui.atom.LabelAndValue

@Composable
fun PokemonBaseStats(
    stats: Map<PokemonStat, Int>?,
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
        PokemonStat.labels.forEach { stat ->
            LabelAndValue(
                label = stat.label,
                value = stats?.get(stat)?.toString(),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
