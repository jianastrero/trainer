package dev.jianastrero.trainer.ui.organism

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.key.Key.Companion.M
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import coil3.compose.AsyncImage
import dev.jianastrero.trainer.ui.atom.Skeleton
import dev.jianastrero.trainer.ui.molecule.PageIndicators
import dev.jianastrero.trainer.ui.theme.Light
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.math.absoluteValue

private data object ImageViewPagerTokens {
    const val ANIM_DURATION = 300
    const val ASPECT_RATIO = 733f/1024f
}

@Composable
fun ImageViewPager(
    images: List<String>,
    modifier: Modifier = Modifier,
) {
    AnimatedContent(
        targetState = images,
        label = "ImageViewPager",
        modifier = modifier
    ) {
        Box {
            if (it.isEmpty()) {
                Skeleton(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxWidth()
                        .aspectRatio(ImageViewPagerTokens.ASPECT_RATIO)
                )
            } else {
                ImageViewPagerContent(images = it)
            }
        }
    }
}

@Composable
private fun BoxScope.ImageViewPagerContent(
    images: List<String>,
) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { if (images.isEmpty()) 1 else images.size },
    )

    HorizontalPager(
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 32.dp),
    ) {
        AsyncImage(
            model = images[it],
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .graphicsLayer {
                    val pageOffset = (
                            (pagerState.currentPage - it) + pagerState.currentPageOffsetFraction
                            ).absoluteValue
                    alpha = lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1 - pageOffset.coerceIn(0f, 1f),
                    )
                    scaleX = lerp(
                        start = 0.8f,
                        stop = 1f,
                        fraction = 1 - pageOffset.coerceIn(0f, 1f),
                    )
                    scaleY = lerp(
                        start = 0.8f,
                        stop = 1f,
                        fraction = 1 - pageOffset.coerceIn(0f, 1f),
                    )
                }
                .fillMaxWidth()
                .aspectRatio(ImageViewPagerTokens.ASPECT_RATIO)
                .padding(24.dp)
        )
    }

    PageIndicators(
        currentPage = pagerState.currentPage,
        pageCount = images.size,
        activeColor = Light,
        borderColor = Color.Transparent,
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Preview
@Composable
private fun ImageViewPagerPreview() {
    ImageViewPager(
        images = listOf(
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/4.png",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/5.png",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/6.png",
        ),
        modifier = Modifier,
    )
}
