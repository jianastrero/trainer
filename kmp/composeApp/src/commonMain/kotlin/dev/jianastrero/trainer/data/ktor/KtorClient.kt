package dev.jianastrero.trainer.data.ktor

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.serialization.json.Json
import kotlin.time.DurationUnit
import kotlin.time.toDuration

class KtorClient(private val baseUrl: String) {

    val client = HttpClient(CIO) {
        expectSuccess = true
        defaultRequest {
            url(baseUrl)
        }

        engine {
            dispatcher = Dispatchers.IO
            pipelining = true
        }
        install(Logging) {
            logger = Logger.SIMPLE
            level = LogLevel.INFO
        }
        install(HttpTimeout) {
            requestTimeoutMillis = 1.toDuration(DurationUnit.MINUTES).inWholeMilliseconds
            connectTimeoutMillis = 1.toDuration(DurationUnit.MINUTES).inWholeMilliseconds
            socketTimeoutMillis = 1.toDuration(DurationUnit.MINUTES).inWholeMilliseconds
        }
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                    explicitNulls = false
                }
            )
        }
    }

}
