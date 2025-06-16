package template.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import studio.lunabee.compose.presenter.LBSinglePresenter
import studio.lunabee.compose.presenter.LBSingleReducer
import studio.lunabee.compose.presenter.PresenterUiState
import studio.lunabee.compose.presenter.ReduceResult
import studio.lunabee.compose.presenter.asResult
import template.domain.GetTemplateFeatureUseCase
import kotlin.uuid.ExperimentalUuidApi

class TemplateFeaturePresenter(
    getTemplateFeatureUseCase: GetTemplateFeatureUseCase,
) : LBSinglePresenter<TemplateFeatureUiState, TemplateFeatureNavScope, TemplateFeatureAction>() {

    private val allTemplateFeatureUseCase = getTemplateFeatureUseCase.asFlow().map { templates ->
        @OptIn(ExperimentalUuidApi::class)
        TemplateFeatureAction.TemplateUpdated(uuid = templates.map { it.id.toHexString() })
    }

    override val flows: List<Flow<TemplateFeatureAction>> = listOf(allTemplateFeatureUseCase)

    override val content: @Composable (uiState: TemplateFeatureUiState) -> Unit = { uiState ->
        TemplateFeatureScreen(uiState = uiState)
    }

    override fun getInitialState(): TemplateFeatureUiState = TemplateFeatureUiState(uuid = emptyList())
    override fun initReducer(): LBSingleReducer<TemplateFeatureUiState, TemplateFeatureNavScope, TemplateFeatureAction> =
        object : LBSingleReducer<TemplateFeatureUiState, TemplateFeatureNavScope, TemplateFeatureAction>() {
            override val coroutineScope: CoroutineScope = viewModelScope
            override val emitUserAction: (TemplateFeatureAction) -> Unit = ::emitUserAction

            override suspend fun reduce(
                actualState: TemplateFeatureUiState,
                action: TemplateFeatureAction,
                performNavigation: (TemplateFeatureNavScope.() -> Unit) -> Unit,
            ): ReduceResult<TemplateFeatureUiState> {
                return when (action) {
                    is TemplateFeatureAction.TemplateUpdated -> actualState.copy(uuid = action.uuid).asResult()
                }
            }
        }
}

data class TemplateFeatureUiState(
    val uuid: List<String>,
) : PresenterUiState

interface TemplateFeatureNavScope

sealed interface TemplateFeatureAction {
    data class TemplateUpdated(
        val uuid: List<String>,
    ) : TemplateFeatureAction
}
