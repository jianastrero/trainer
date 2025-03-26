package dev.jianastrero.trainer.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.DrawerDefaults.shape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import dev.jianastrero.trainer.ui.theme.TrainerTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun PokemonCard(
    zIndex: Int,
    name: String,
    previewImageUrl: String,
    modifier: Modifier = Modifier
) {
    val enabled by remember(zIndex) {
        derivedStateOf {
            zIndex > 1
        }
    }
    val name = name.split("\\s+".toRegex())
        .joinToString(" ") { it.capitalize(Locale.current) }
    val shadowColor = if (TrainerTheme.isDarkMode) {
        MaterialTheme.colors.onBackground
    } else {
        MaterialTheme.colors.primary
    }

    LaunchedEffect(Unit) {
        println("JIANDDEBUG -> previewImageUrl: $previewImageUrl")
    }

    Column(
        modifier = modifier
            .shadow(
                elevation = if (enabled) 16.dp else 0.dp,
                shape = MaterialTheme.shapes.medium,
                ambientColor = shadowColor,
                spotColor = shadowColor
            )
            .background(
                color = MaterialTheme.colors.surface,
                shape = MaterialTheme.shapes.medium
            ),
    ) {
        AsyncImage(
            model = previewImageUrl,
            contentDescription = name,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(24.dp)
        )
        Text(
            text = name,
            color = MaterialTheme.colors.onBackground,
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 2.sp,
            lineHeight = 32.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        )
    }
}

@Preview
@Composable
private fun PokemonCardPreview() {
    TrainerTheme {
        PokemonCard(
            2,
            "Pikachu",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png",
            modifier = Modifier.size(320.dp, 640.dp)
        )
    }
}
