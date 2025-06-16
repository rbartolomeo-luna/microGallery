package template.remote

import template.data.Template

interface TemplateRemoteDatasource {
    suspend fun fetchTemplate(): Template
}
