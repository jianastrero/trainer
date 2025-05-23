package dev.jianastrero.trainer.ui.organism

import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import dev.jianastrero.trainer.domain.enumeration.PokemonType
import dev.jianastrero.trainer.domain.ext.capitalized
import dev.jianastrero.trainer.ui.atom.LoadingImage
import dev.jianastrero.trainer.ui.modifier.RadialGradientTokens
import dev.jianastrero.trainer.ui.modifier.background
import dev.jianastrero.trainer.ui.modifier.skeleton
import dev.jianastrero.trainer.ui.modifier.then
import dev.jianastrero.trainer.ui.theme.TrainerTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

private data object CardTokens {
    const val ANIM_X_OFFSET = 2f
    const val ANIM_Z_ROTATION = 30f
    const val ANIM_DURATION = 300
}

sealed interface CardAction {
    data object SwipeRight : CardAction
    data object SwipeLeft : CardAction
    data object View : CardAction
}

private val cardTransitionSpec: @Composable Transition.Segment<CardAction?>.() -> FiniteAnimationSpec<Float> = {
    when {
        targetState == CardAction.SwipeRight ||
        targetState == CardAction.SwipeLeft -> tween(durationMillis = CardTokens.ANIM_DURATION)
        else -> tween(durationMillis = 0)
    }
}

@Composable
fun PokemonCard(
    name: String,
    imageUrl: String,
    color: Color,
    modifier: Modifier = Modifier,
    cardAction: CardAction? = null,
    onCardAction: (CardAction) -> Unit = {},
    enabled: Boolean = true,
    fontSize: TextUnit = 32.sp
) {
    var size by remember { mutableStateOf(Size.Unspecified) }

    val animShadow by animateDpAsState(
        targetValue = if (cardAction == null) 8.dp else 0.dp,
        animationSpec = tween(
            durationMillis = if (cardAction == null) CardTokens.ANIM_DURATION else 0
        )
    )
    val transition = updateTransition(cardAction)
    val animTranslationX by transition.animateFloat(cardTransitionSpec) {
        when (it) {
            CardAction.SwipeRight -> CardTokens.ANIM_X_OFFSET * size.width
            CardAction.SwipeLeft -> -CardTokens.ANIM_X_OFFSET * size.width
            else -> 0f
        }
    }
    val animRotationZ by transition.animateFloat(cardTransitionSpec) {
        when (it) {
            CardAction.SwipeRight -> CardTokens.ANIM_Z_ROTATION
            CardAction.SwipeLeft -> -CardTokens.ANIM_Z_ROTATION
            else -> 0f
        }
    }

    LaunchedEffect(enabled, transition.isRunning) {
        if (!enabled) return@LaunchedEffect
        if (!transition.isRunning) {
            if (cardAction != null) onCardAction(cardAction)
        }
    }

    Column(
        modifier = modifier
            .onGloballyPositioned { size = it.size.toSize() }
            .then(enabled) {
                Modifier.graphicsLayer {
                    translationX = animTranslationX
                    rotationZ = animRotationZ
                }
            }
            .shadow(
                elevation = if (enabled) animShadow else 0.dp,
                shape = TrainerTheme.shapes.medium,
                ambientColor = color,
                spotColor = color
            )
            .background(
                radialColor = color,
                backgroundColor = TrainerTheme.colors.background,
                radiusBias = RadialGradientTokens.Bias.Height,
                shape = TrainerTheme.shapes.medium
            )
            .then(name.isEmpty()) {
                Modifier
                    .clip(TrainerTheme.shapes.medium)
                    .skeleton()
            }
            .border(
                width = 1.dp,
                color = color,
                shape = TrainerTheme.shapes.medium
            )
            .clip(TrainerTheme.shapes.medium)
            .clickable(enabled = enabled) {
                onCardAction(CardAction.View)
            }
    ) {
        LoadingImage(
            uri = imageUrl,
            contentDescription = name,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(24.dp)
        )
        Text(
            text = name.capitalized,
            color = TrainerTheme.colors.onBackground,
            fontSize = fontSize,
            fontWeight = FontWeight.Bold,
            letterSpacing = 2.sp,
            lineHeight = 32.sp,
            textAlign = TextAlign.Center,
            style = TrainerTheme.typography.body1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 12.dp,
                    end = 12.dp,
                    top = 12.dp,
                    bottom = 24.dp
                )
        )
    }
}

@Preview
@Composable
private fun PokemonCardPreview() {
    TrainerTheme {
        PokemonCard(
            "Pikachu",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png",
            color = PokemonType.Psychic.color,
            modifier = Modifier.size(320.dp, 640.dp)
        )
    }
}
