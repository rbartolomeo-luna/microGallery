package studio.lunabee.amicrogallery



import android.util.Log
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import studio.lunabee.amicrogallery.android.core.ui.component.topappbar.MicroGalleryBottomBar
import studio.lunabee.amicrogallery.calendar.CalendarDestination
import studio.lunabee.amicrogallery.calendar.CalendarNavScope
import studio.lunabee.amicrogallery.lastmonth.LastMonthDestination
import studio.lunabee.amicrogallery.lastmonth.LastMonthNavScope
import studio.lunabee.amicrogallery.untimed.UntimedDestination
import studio.lunabee.amicrogallery.untimed.UntimedNavScope
import kotlin.reflect.KClass

private const val TAG = "MainNavGraph"

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun MainNavGraph(
    navHostController : NavHostController,
    startDestination: KClass<*>,
){
    Box (modifier = Modifier.fillMaxSize()){
        SharedTransitionLayout {
            NavHost(
                navController = navHostController,
                startDestination = startDestination
            ) {
                CalendarDestination.composable(
                    navGraphBuilder = this,
                    navScope = object : CalendarNavScope {
                        override val navigateToMicroYear = { it: Int -> val temp = Log.d(TAG, "must navigate to year $it")}
                    },
                )
                UntimedDestination.composable(
                    navGraphBuilder = this,
                    navScope = object : UntimedNavScope {}
                )
                LastMonthDestination.composable(
                    navGraphBuilder = this,
                    navScope = object : LastMonthNavScope {}
                )
            }
        }
        MicroGalleryBottomBar(modifier = Modifier.align(Alignment.BottomCenter))
    }

}