package dev.jianastrero.trainer

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import dev.jianastrero.trainer.domain.enumeration.PokemonType
import dev.jianastrero.trainer.ui.atom.TrainerButton
import dev.jianastrero.trainer.ui.effect.SystemBarIconColorEffect
import dev.jianastrero.trainer.ui.theme.TrainerTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import trainer.composeapp.generated.resources.Res
import trainer.composeapp.generated.resources.compose_multiplatform
import trainer.composeapp.generated.resources.fighting

@Composable
@Preview
fun App() {
    SystemBarIconColorEffect(false)

    TrainerTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .fillMaxSize()
                .systemBarsPadding()
        ) {
            TrainerButton(
                text = "Hello world!",
                onClick = { showContent = !showContent }
            )
            LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f)) {
                items(PokemonType.entries) { pokemonType ->
                    Row(
                        modifier = Modifier
                            .background(pokemonType.color)
                            .fillMaxWidth()
                            .padding(12.dp)
                    ) {
                        if (pokemonType.icon != null) {
                            Image(
                                painter = painterResource(pokemonType.icon),
                                contentDescription = null,
                                modifier = Modifier.size(36.dp)
                            )
                        }
                        Text(
                            text = pokemonType.name,
                            style = TextStyle(
                                color = Color.White,
                                shadow = Shadow(
                                    color = Color.Black,
                                    offset = Offset(4f, 4f),
                                    blurRadius = 4f
                                )
                            )
                        )
                    }
                }
            }
        }
    }
}
