package template.remote

import template.data.Template

class TemplateRemoteDatasourceImpl(
    private val client: KtorTemplateClient,
) : TemplateRemoteDatasource {
    override suspend fun fetchTemplate(): Template = client.fetchTemplate().toModel()
}
