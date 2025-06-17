package studio.lunabee.amicrogallery.android.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import studio.lunabee.amicrogallery.android.core.ui.component.topappbar.microGalleryBottomBar
import studio.lunabee.amicrogallery.android.core.ui.theme.CoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoreTheme {
                Column {
                    Spacer(modifier = Modifier.height(50.dp))
                    microGalleryBottomBar()
                }

            }
        }
    }
}
