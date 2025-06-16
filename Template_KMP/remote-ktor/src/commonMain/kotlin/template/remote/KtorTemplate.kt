package template.remote

import kotlinx.serialization.Serializable
import template.data.Template
import kotlin.uuid.Uuid

@Serializable
data class KtorTemplate(
    val id: String,
) {
    fun toModel(): Template {
        return Template(
            id = Uuid.parse(id),
        )
    }
}
