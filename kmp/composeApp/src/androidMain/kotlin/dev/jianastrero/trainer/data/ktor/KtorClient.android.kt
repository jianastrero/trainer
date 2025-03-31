package dev.jianastrero.trainer.data.ktor

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO

actual val defaultHttpClient: HttpClient = HttpClient(CIO)
