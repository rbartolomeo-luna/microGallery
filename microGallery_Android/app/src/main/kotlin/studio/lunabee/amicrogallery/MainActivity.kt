package studio.lunabee.amicrogallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.RedMaterialTheme
import studio.lunabee.amicrogallery.calendar.CalendarDestination

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navHostController = rememberNavController()
            RedMaterialTheme {
                RootDrawer(
                    navHostController = navHostController,
                    startDestination = CalendarDestination::class
                )
            }
        }
    }
}
