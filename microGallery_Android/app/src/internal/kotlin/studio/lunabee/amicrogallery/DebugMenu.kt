package studio.lunabee.amicrogallery

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController

@SuppressLint("RestrictedApi")
@Composable
fun DebugMenu(
    navHostController: NavHostController
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.background)
            .systemBarsPadding(),
    ) {
        item {
            Text(
                text = "Debug menu 😘",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "You are on screen:  { id :  ${navHostController.currentDestination?.id}}",
                style = MaterialTheme.typography.bodyMedium

            )
        }
    }

}
