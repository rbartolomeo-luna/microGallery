package template.domain

import kotlinx.coroutines.flow.Flow
import template.data.TemplateFeature
import template.repository.TemplateFeatureRepository

class GetTemplateFeatureUseCase(
    private val templateFeatureRepository: TemplateFeatureRepository,
) {
    fun asFlow(): Flow<List<TemplateFeature>> = templateFeatureRepository.getAllTemplateAsFlow()
}
