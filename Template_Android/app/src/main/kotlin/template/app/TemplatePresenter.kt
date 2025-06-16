package template.app

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
import studio.lunabee.compose.presenter.withSideEffect
import template.domain.FetchTemplateUseCase
import template.domain.GetAllTemplateUseCase
import kotlin.uuid.ExperimentalUuidApi

class TemplatePresenter(
    private val fetchTemplateUseCase: FetchTemplateUseCase,
    getAllTemplateUseCase: GetAllTemplateUseCase,
) : LBSinglePresenter<TemplateUiState, TemplateNavScope, TemplateAction>() {
    private val allTemplateUseCase = getAllTemplateUseCase.asFlow().map { templates ->
        @OptIn(ExperimentalUuidApi::class)
        TemplateAction.TemplateUpdated(uuid = templates.map { it.id.toHexString() })
    }

    override val flows: List<Flow<TemplateAction>> = listOf(allTemplateUseCase)

    override val content: @Composable (uiState: TemplateUiState) -> Unit = { uiState ->
        TemplateScreen(uiState = uiState)
    }

    override fun getInitialState(): TemplateUiState = TemplateUiState(
        uuid = emptyList(),
        onFetchClicked = { emitUserAction(TemplateAction.FetchData) },
        onNavigateClicked = { emitUserAction(TemplateAction.NavigateToTemplate) },
    )

    override fun initReducer(): LBSingleReducer<TemplateUiState, TemplateNavScope, TemplateAction> =
        object : LBSingleReducer<TemplateUiState, TemplateNavScope, TemplateAction>() {
            override val coroutineScope: CoroutineScope = viewModelScope
            override val emitUserAction: (TemplateAction) -> Unit = ::emitUserAction

            override suspend fun reduce(
                actualState: TemplateUiState,
                action: TemplateAction,
                performNavigation: (TemplateNavScope.() -> Unit) -> Unit,
            ): ReduceResult<TemplateUiState> {
                return when (action) {
                    is TemplateAction.TemplateUpdated -> actualState.copy(uuid = action.uuid).asResult()
                    is TemplateAction.FetchData -> actualState withSideEffect { fetchTemplateUseCase() }
                    is TemplateAction.NavigateToTemplate -> actualState withSideEffect { performNavigation { navigateToTemplateScreen() } }
                }
            }
        }
}

data class TemplateUiState(
    val uuid: List<String>,
    val onFetchClicked: () -> Unit,
    val onNavigateClicked: () -> Unit,
) : PresenterUiState

interface TemplateNavScope {
    val navigateToTemplateScreen: () -> Unit
}

sealed interface TemplateAction {
    data class TemplateUpdated(
        val uuid: List<String>,
    ) : TemplateAction

    data object NavigateToTemplate : TemplateAction

    data object FetchData : TemplateAction
}
