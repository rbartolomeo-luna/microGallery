package template.local

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import template.data.Template
import template.data.TemplateFeature

class TemplateLocalDatasourceImpl(
    private val dao: TemplateDao,
) : TemplateLocalDatasource {
    override fun getAllTemplateAsFlow(): Flow<List<Template>> = dao.getAllTemplateAsFlow()
        .map { entities -> entities.map(TemplateEntity::toModel) }

    override fun getAllTemplateFeatureAsFlow(): Flow<List<TemplateFeature>> = dao.getAllTemplateAsFlow()
        .map { it.map(TemplateEntity::toFeature) }

    override suspend fun getAllTemplate(): List<Template> = dao.getAllTemplate().map(TemplateEntity::toModel)
    override suspend fun upsertTemplate(template: Template): Unit = dao.upsertTemplate(
        template = TemplateEntity.fromModel(model = template),
    )
}
