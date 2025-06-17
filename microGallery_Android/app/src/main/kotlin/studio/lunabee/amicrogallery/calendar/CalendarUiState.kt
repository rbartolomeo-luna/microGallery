package studio.lunabee.amicrogallery.calendar

import androidx.compose.ui.text.input.TextFieldValue
import studio.lunabee.compose.presenter.PresenterUiState
import kotlin.String

sealed interface CalendarUiState : PresenterUiState {
    val textUiShown : String
    data class Default (
        val count : Int
    ) : CalendarUiState {
        override val textUiShown: String = "hello from Calendar drawer"
    }
}