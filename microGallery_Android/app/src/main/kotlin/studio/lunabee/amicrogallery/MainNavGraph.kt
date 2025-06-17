package studio.lunabee.amicrogallery



import android.util.Log
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import studio.lunabee.amicrogallery.android.core.ui.component.topappbar.microGalleryBottomBar
import studio.lunabee.amicrogallery.calendar.CalendarDestination
import studio.lunabee.amicrogallery.calendar.CalendarNavScope
import kotlin.reflect.KClass

private const val TAG = "MainNavGraph"

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun MainNavGraph(
    navHostController : NavHostController,
    startDestination: KClass<*>,
){
    Box {
        SharedTransitionLayout {
            NavHost(
                navController = navHostController,
                startDestination = startDestination,
            ) {
                CalendarDestination.composable(
                    navGraphBuilder = this,
                    navScope = object : CalendarNavScope {
                        override val navigateToMicroYear = { it: Int -> val temp = Log.d(TAG, "must navigate to year $it")}
                            //navHostController.navigate(DashboardDestination) { popUpTo(WelcomeDestination) { inclusive = true } }
                        }
                )
            }
        }
    }
    microGalleryBottomBar()
}