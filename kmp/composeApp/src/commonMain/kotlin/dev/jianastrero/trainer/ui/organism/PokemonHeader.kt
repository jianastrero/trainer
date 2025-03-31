package dev.jianastrero.trainer.ui.organism

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.jianastrero.trainer.domain.entity.Pokemon
import dev.jianastrero.trainer.domain.ext.capitalized
import dev.jianastrero.trainer.ui.atom.Skeleton
import dev.jianastrero.trainer.ui.molecule.PokemonTypePills
import dev.jianastrero.trainer.ui.theme.Light
import dev.jianastrero.trainer.ui.theme.TrainerTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PokemonHeader(
    pokemon: Pokemon?,
    modifier: Modifier = Modifier,
    revealDuration: Int = 1000,
) {
    AnimatedContent(
        targetState = pokemon,
        label = "PokemonHeader",
        transitionSpec = {
            fadeIn(tween(revealDuration)) togetherWith fadeOut(tween(revealDuration))
        },
        modifier = modifier
    ) { pokemon ->
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            if (pokemon == null) {
                Skeleton(
                    modifier = Modifier
                        .size(240.dp, 48.dp)
                        .clip(TrainerTheme.shapes.small)
                )
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                ) {
                    repeat(2) {
                        Skeleton(
                            modifier = Modifier
                                .size(96.dp, 26.dp)
                                .clip(TrainerTheme.shapes.small)
                        )
                    }
                }
            } else {
                Text(
                    text = pokemon.name.capitalized,
                    color = Light,
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Black,
                    style = TrainerTheme.typography.body1,
                )
                PokemonTypePills(
                    pokemonTypes = pokemon.types,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    }
}
