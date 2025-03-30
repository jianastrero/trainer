package dev.jianastrero.trainer.data.coil

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import coil3.ImageLoader
import coil3.compose.LocalPlatformContext
import coil3.disk.DiskCache
import coil3.memory.MemoryCache
import coil3.request.crossfade
import dev.jianastrero.trainer.platform.KMPContext
import dev.jianastrero.trainer.platform.cachePath
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.compose.koinInject


@Composable
fun rememberImageLoader(kmpContext: KMPContext = koinInject()): ImageLoader {
    val platformContext = LocalPlatformContext.current
    val imageLoader = remember(kmpContext) {
        val builder = ImageLoader.Builder(platformContext)
            .crossfade(true)
            .coroutineContext(Dispatchers.IO)
            .memoryCache {
                MemoryCache.Builder().build()
            }

        val cachePath = kmpContext.cachePath

        if (cachePath != null) {
            builder
                .diskCache {
                    DiskCache.Builder()
                        .directory(cachePath.resolve("coil", true))
                        .build()
                }
        }

        builder.build()
    }

    return imageLoader
}
