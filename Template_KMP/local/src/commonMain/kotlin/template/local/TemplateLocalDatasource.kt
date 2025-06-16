package template.local

import kotlinx.coroutines.flow.Flow
import template.data.Template
import template.data.TemplateFeature

interface TemplateLocalDatasource {
    fun getAllTemplateAsFlow(): Flow<List<Template>>
    fun getAllTemplateFeatureAsFlow(): Flow<List<TemplateFeature>>
    suspend fun getAllTemplate(): List<Template>
    suspend fun upsertTemplate(template: Template)
}
