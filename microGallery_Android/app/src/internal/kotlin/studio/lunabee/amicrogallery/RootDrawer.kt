package studio.lunabee.amicrogallery

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import kotlin.reflect.KClass

@Composable
fun RootDrawer(
    navHostController: NavHostController,
    startDestination: KClass<*>,
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        content = {
            MainNavGraph(
                navHostController = navHostController,
                startDestination = startDestination,
            )
        },
        drawerContent = { DebugMenu() },
    )
}
