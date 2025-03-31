package dev.jianastrero.trainer.ui.organism

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import dev.jianastrero.trainer.ui.atom.LoadingImage
import dev.jianastrero.trainer.ui.atom.Skeleton
import dev.jianastrero.trainer.ui.molecule.PageIndicators
import dev.jianastrero.trainer.ui.theme.Light
import dev.jianastrero.trainer.ui.theme.TrainerTheme
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
    activePageIndicatorColor: Color = Light,
    pageIndicatorSpacing: Dp = 12.dp,
) {
    AnimatedContent(
        targetState = images,
        label = "ImageViewPager",
        transitionSpec = {
            fadeIn(tween(ImageViewPagerTokens.ANIM_DURATION)) togetherWith
                    fadeOut(tween(ImageViewPagerTokens.ANIM_DURATION))
        },
        modifier = modifier
    ) {
        Column {
            if (it.isEmpty()) {
                SkeletonLoading(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 12.dp)
                )
            } else {
                ImageViewPagerContent(
                    images = it,
                    activePageIndicatorColor = activePageIndicatorColor,
                    pageIndicatorSpacing = pageIndicatorSpacing,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
private fun SkeletonLoading(
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Skeleton(
            modifier = Modifier
                .size(240.dp, 320.dp)
                .clip(TrainerTheme.shapes.small)
        )
        Skeleton(
            modifier = Modifier
                .size(240.dp * 0.9f, 320.dp * 0.9f)
                .clip(TrainerTheme.shapes.small)
        )
    }
}

@Composable
private fun ImageViewPagerContent(
    images: List<String>,
    activePageIndicatorColor: Color,
    pageIndicatorSpacing: Dp,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { if (images.isEmpty()) 1 else images.size },
    )

    Column(modifier = modifier) {
        HorizontalPager(
            state = pagerState,
            pageSize = PageSize.Fixed(240.dp),
            snapPosition = SnapPosition.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            LoadingImage(
                uri = images[it],
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .graphicsLayer {
                        val pageOffset = (pagerState.currentPage - it) + pagerState.currentPageOffsetFraction
                        val pageOffsetAbs = pageOffset.absoluteValue
                        alpha = lerp(
                            start = 0.4f,
                            stop = 1f,
                            fraction = 1 - pageOffsetAbs.coerceIn(0f, 1f),
                        )
                        scaleX = lerp(
                            start = 0.9f,
                            stop = 1f,
                            fraction = 1 - pageOffsetAbs.coerceIn(0f, 1f),
                        )
                        scaleY = lerp(
                            start = 0.9f,
                            stop = 1f,
                            fraction = 1 - pageOffsetAbs.coerceIn(0f, 1f),
                        )
                    }
                    .fillMaxWidth()
                    .height(320.dp)
            )
        }

        PageIndicators(
            currentPage = pagerState.currentPage,
            pageCount = images.size,
            activeColor = activePageIndicatorColor,
            inactiveColor = TrainerTheme.colors.onBackground.copy(alpha = 0.4f),
            spacing = pageIndicatorSpacing,
            borderColor = TrainerTheme.colors.background,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height(32.dp)
        )
    }
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
