package studio.lunabee.amicrogallery.calendar

import androidx.hilt.navigation.compose.hiltViewModel

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import studio.lunabee.amicrogallery.Destination

@Serializable
object CalendarDestination : Destination {

    fun composable(navGraphBuilder: NavGraphBuilder, navScope: CalendarNavScope) {
        navGraphBuilder.composable<CalendarDestination> {
            val presenter: CalendarPresenter = hiltViewModel()
            presenter.invoke(navScope)
        }
    }
}