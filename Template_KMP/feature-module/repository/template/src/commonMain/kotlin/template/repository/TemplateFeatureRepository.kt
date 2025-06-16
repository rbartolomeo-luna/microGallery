package template.repository

import kotlinx.coroutines.flow.Flow
import template.data.TemplateFeature
import template.local.TemplateLocalDatasource

class TemplateFeatureRepository(
    private val localDatasource: TemplateLocalDatasource,
) {
    fun getAllTemplateAsFlow(): Flow<List<TemplateFeature>> = localDatasource.getAllTemplateFeatureAsFlow()
}
