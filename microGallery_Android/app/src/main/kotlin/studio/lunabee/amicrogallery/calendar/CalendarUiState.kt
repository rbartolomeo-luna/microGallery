package studio.lunabee.amicrogallery.calendar

import studio.lunabee.compose.presenter.PresenterUiState
import studio.lunabee.microgallery.android.domain.Node

data class CalendarUiState(
    val textUiShown : String,
    val rootNode : Node?
) : PresenterUiState