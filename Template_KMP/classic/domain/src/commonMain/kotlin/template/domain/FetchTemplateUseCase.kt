package template.domain

import com.lunabee.lbcore.model.LBResult
import template.error.CoreError
import template.repository.TemplateRepository

class FetchTemplateUseCase(
    private val templateRepository: TemplateRepository,
) {
    suspend operator fun invoke(): LBResult<Unit> {
        return CoreError.runCatching {
            val newTemplate = templateRepository.fetchTemplate()
            templateRepository.upsertTemplate(template = newTemplate)
        }
    }
}
