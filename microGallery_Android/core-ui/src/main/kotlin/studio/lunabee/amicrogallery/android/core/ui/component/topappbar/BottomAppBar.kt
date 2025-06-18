package studio.lunabee.amicrogallery.android.core.ui.component.topappbar



import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.HorizontalFloatingToolbar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import studio.lunabee.amicrogallery.core.ui.R

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun MicroGalleryBottomBar(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    navigateToCalendar : () -> Unit,
    navigateToUntimed : () -> Unit,
    navigateToLastMonth : () -> Unit
) {
        HorizontalFloatingToolbar(
            expanded = true,
            modifier = modifier
        )
        {
            IconButton(onClick = navigateToCalendar) {
                Icon(painterResource(R.drawable.calendar), contentDescription = stringResource(R.string.calendar_icon_button))
            }
            IconButton(onClick = navigateToUntimed) {
                Icon(painterResource(R.drawable.not_time), contentDescription = stringResource(R.string.untimed_icon_button))
            }
            IconButton(onClick = navigateToLastMonth) {
                Icon(painterResource(R.drawable.month_24px), contentDescription = stringResource(R.string.lastmonth_icon_button))
            }
        }

}

