package template.remote

import io.ktor.client.call.body
import io.ktor.client.request.get

class KtorTemplateClient(
    private val httpClient: CoreHttpClient,
) {
    suspend fun fetchTemplate(): KtorTemplate = KtorTemplate(
        id = httpClient.instance.get(urlString = "generate/v4").body<List<String>>()[0],
    )
}
