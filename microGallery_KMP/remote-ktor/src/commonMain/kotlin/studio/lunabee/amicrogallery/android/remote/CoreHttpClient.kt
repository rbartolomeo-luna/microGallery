package studio.lunabee.amicrogallery.android.remote

import com.lunabee.ktor.LBKtorExceptionHandler
import com.lunabee.ktor.LBKtorJson
import com.lunabee.ktor.LBKtorKermit
import io.ktor.client.HttpClient
import studio.lunabee.amicrogallery.android.error.CoreError

class CoreHttpClient(
    private val baseUrl: String,
) {
    val instance: HttpClient = HttpClient {
        install(LBKtorExceptionHandler) {
            mapErr = { CoreError(cause = it) }
        }
        install(LBKtorJson) {
            url = baseUrl
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
            explicitNulls = false
        }
        install(LBKtorKermit) {
            logLevel = LBKtorKermit.LogLevel.All
        }
    }
}
