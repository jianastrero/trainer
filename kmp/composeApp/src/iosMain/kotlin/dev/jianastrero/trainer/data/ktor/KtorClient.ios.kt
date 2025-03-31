package dev.jianastrero.trainer.data.ktor

import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin

actual val defaultHttpClient: HttpClient = HttpClient(Darwin) {
    engine {
        configureRequest {
            setAllowsCellularAccess(true)
            setAllowsExpensiveNetworkAccess(true)
        }
    }
}
