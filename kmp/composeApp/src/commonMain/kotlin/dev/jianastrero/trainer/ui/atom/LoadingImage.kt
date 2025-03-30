package dev.jianastrero.trainer.ui.atom

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import coil3.ImageLoader
import coil3.compose.SubcomposeAsyncImage
import dev.jianastrero.trainer.data.coil.rememberImageLoader

@Composable
fun LoadingImage(
    uri: String,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Crop,
    colorFilter: ColorFilter? = null,
    imageLoader: ImageLoader = rememberImageLoader()
) {
    SubcomposeAsyncImage(
        model = uri,
        contentDescription = contentDescription,
        contentScale = contentScale,
        colorFilter = colorFilter,
        loading = {
            Skeleton(modifier = Modifier.fillMaxSize())
        },
        error = {
            DittoImage(modifier = Modifier.fillMaxSize())
        },
        imageLoader = imageLoader,
        modifier = modifier,
    )
}
