package template.domain

import kotlinx.coroutines.flow.Flow
import template.data.Template
import template.repository.TemplateRepository

class GetAllTemplateUseCase(
    private val templateRepository: TemplateRepository,
) {
    suspend operator fun invoke(): List<Template> = templateRepository.getAllTemplate()
    fun asFlow(): Flow<List<Template>> = templateRepository.getAllTemplateAsFlow()
}
