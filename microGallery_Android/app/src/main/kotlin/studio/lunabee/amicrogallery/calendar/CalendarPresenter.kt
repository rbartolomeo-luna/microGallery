package studio.lunabee.amicrogallery.calendar

import androidx.compose.runtime.Composable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import studio.lunabee.compose.presenter.LBPresenter
import studio.lunabee.compose.presenter.LBSimpleReducer
import javax.inject.Inject

@HiltViewModel
class CalendarPresenter @Inject constructor() : LBPresenter<CalendarUiState, CalendarNavScope, CalendarAction>() {
    override val flows: List<Flow<CalendarAction>>
        get() = TODO("Not yet implemented")


    override fun getInitialState(): CalendarUiState = CalendarUiState.Default(5)
    override fun getReducerByState(actualState: CalendarUiState): LBSimpleReducer<CalendarUiState, CalendarNavScope, CalendarAction> {
        TODO("Not yet implemented")
    }
    override val content: @Composable ((CalendarUiState) -> Unit) = { CalendarScreen(it) }

}