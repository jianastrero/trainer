package dev.jianastrero.trainer.data.coil

import coil3.EventListener
import coil3.request.ErrorResult
import coil3.request.ImageRequest

actual class ImageLoaderEventListener : EventListener() {
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
