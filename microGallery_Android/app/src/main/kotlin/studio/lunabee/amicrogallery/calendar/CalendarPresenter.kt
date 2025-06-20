package studio.lunabee.amicrogallery.calendar

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewModelScope
import com.lunabee.lbcore.model.LBResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import studio.lunabee.compose.presenter.LBSinglePresenter
import studio.lunabee.compose.presenter.LBSingleReducer
import studio.lunabee.microgallery.android.domain.Node
import studio.lunabee.microgallery.android.domain.calendar.usecase.UpdateTreeUseCase

private val TAG = "CalendarPresenter"

class CalendarPresenter(
    private val updateTreeUseCase: UpdateTreeUseCase
) : LBSinglePresenter<CalendarUiState, CalendarNavScope, CalendarAction>(

) {
    override val flows: List<Flow<CalendarAction>> = emptyList()

    override fun getInitialState(): CalendarUiState = CalendarUiState(
        textUiShown = "Default value",
        rootNode = null
    )

    override fun initReducer(): LBSingleReducer<CalendarUiState, CalendarNavScope, CalendarAction> {
        return CalendarReducer(viewModelScope,::emitUserAction)
    }

    init {
        refreshEvent()
    }

    private fun refreshEvent() {
        viewModelScope.launch {

            when (val result: LBResult<Node> = updateTreeUseCase() ) {
                is LBResult.Success -> {emitUserAction(CalendarAction.StopRefreshing(result.data!!))}
                is LBResult.Failure -> {
                }
            }
            Log.d(TAG, "fetch is over")

        }
    }

    override val content: @Composable ((CalendarUiState) -> Unit) = { CalendarScreen(it) }

}