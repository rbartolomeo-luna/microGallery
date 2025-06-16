package template.repository

import kotlinx.coroutines.flow.Flow
import template.data.Template
import template.local.TemplateLocalDatasource
import template.remote.TemplateRemoteDatasource

class TemplateRepository(
    private val localDatasource: TemplateLocalDatasource,
    private val remoteDatasource: TemplateRemoteDatasource,
) {
    fun getAllTemplateAsFlow(): Flow<List<Template>> = localDatasource.getAllTemplateAsFlow()
    suspend fun getAllTemplate(): List<Template> = localDatasource.getAllTemplate()
    suspend fun fetchTemplate(): Template = remoteDatasource.fetchTemplate()
    suspend fun upsertTemplate(template: Template) = localDatasource.upsertTemplate(template = template)
}
