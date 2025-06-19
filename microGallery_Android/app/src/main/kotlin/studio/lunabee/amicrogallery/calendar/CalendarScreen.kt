package studio.lunabee.amicrogallery.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonShapes
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.IconButtonShapes
import androidx.compose.material3.MaterialShapes
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import studio.lunabee.amicrogallery.android.core.ui.component.image.MicroGalleryImage

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun CalendarScreen(calendarUiState : CalendarUiState){
    Column {
        Text(
            text = calendarUiState.textUiShown
        )
        Button(
            onClick = {},
            contentPadding = PaddingValues(0.dp),
            shapes = ButtonShapes(RectangleShape, RectangleShape)
        ) {
            MicroGalleryImage(
                url = "http://92.150.239.130/disque/photos/ranged/ryan.jpg",
                modifier = Modifier.fillMaxWidth(0.3f)
            )
        }

    }
}