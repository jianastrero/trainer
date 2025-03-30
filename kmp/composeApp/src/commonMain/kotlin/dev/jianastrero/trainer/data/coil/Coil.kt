package dev.jianastrero.trainer.data.coil

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import coil3.EventListener
import coil3.ImageLoader
import coil3.compose.LocalPlatformContext
import coil3.disk.DiskCache
import coil3.memory.MemoryCache
import coil3.request.ErrorResult
import coil3.request.ImageRequest
import coil3.request.crossfade
import dev.jianastrero.trainer.platform.KMPContext
import dev.jianastrero.trainer.platform.cachePath
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.compose.koinInject

private data object ImageLoaderTokens {
    const val MEMORY_CACHE = 10L * 1024 * 1024 // 10mb in bytes
    const val DISK_CACHE = 2L * 1024 * 1024 * 1024 // 2gb in bytes
}

@Composable
fun rememberImageLoader(kmpContext: KMPContext = koinInject()): ImageLoader {
    val platformContext = LocalPlatformContext.current
    val imageLoader = remember(kmpContext) {
        val builder = ImageLoader.Builder(platformContext)
            .crossfade(true)
            .coroutineContext(Dispatchers.IO)
            .memoryCache {
                MemoryCache.Builder()
                    .maxSizeBytes(ImageLoaderTokens.MEMORY_CACHE)
                    .build()
            }

        val cachePath = kmpContext.cachePath

        if (cachePath != null) {
            builder
                .diskCache {
                    DiskCache.Builder()
                        .directory(cachePath.resolve("coil", true))
                        .maxSizeBytes(ImageLoaderTokens.DISK_CACHE)
                        .build()
                }
        }

        builder
            .eventListener(
                object : EventListener() {
                    override fun onError(request: ImageRequest, result: ErrorResult) {
                        super.onError(request, result)

                        val memoryCacheKey = result.request.memoryCacheKey
                        if (memoryCacheKey != null) {
                            request.memoryCacheKey?.removeSurrounding(memoryCacheKey)
                        }
                        val diskCacheKey = result.request.diskCacheKey
                        if (diskCacheKey != null) {
                            request.diskCacheKey?.removeSurrounding(diskCacheKey)
                        }
                    }
                }
            )
            .build()
    }

    return imageLoader
}
