package template.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import template.data.Template
import template.data.TemplateFeature
import kotlin.uuid.Uuid

@Entity
data class TemplateEntity(
    @PrimaryKey
    val id: String,
) {
    fun toModel(): Template = Template(id = Uuid.parseHex(id))
    fun toFeature(): TemplateFeature = TemplateFeature(id = Uuid.parseHex(id))

    companion object {
        fun fromModel(model: Template): TemplateEntity {
            return TemplateEntity(
                id = model.id.toHexString(),
            )
        }
    }
}
