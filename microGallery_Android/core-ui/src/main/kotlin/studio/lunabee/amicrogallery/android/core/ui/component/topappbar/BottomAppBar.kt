package studio.lunabee.amicrogallery.android.core.ui.component.topappbar


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.HorizontalFloatingToolbar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import studio.lunabee.amicrogallery.core.ui.R


@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun microGalleryBottomBar() {
    Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        HorizontalFloatingToolbar(
            expanded = true
        )
        {
            IconButton(onClick = { /* do something */ }) {
                Icon(painterResource(R.drawable.calendar), contentDescription = "Localized description")
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    painterResource(R.drawable.not_time),
                    contentDescription = "Localized description",
                )
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    painterResource(R.drawable.month_24px),
                    contentDescription = "Localized description",
                )
            }
        }
    }
}

