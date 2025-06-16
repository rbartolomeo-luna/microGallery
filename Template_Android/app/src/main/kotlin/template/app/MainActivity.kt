package template.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import template.core.ui.theme.CoreTheme
import template.ui.TemplateFeatureDestination
import template.ui.TemplateFeatureNavScope
import kotlin.reflect.KClass

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoreTheme {
                TemplateNavGraph(
                    startDestination = TemplateDestination::class,
                )
            }
        }
    }
}

@Composable
fun TemplateNavGraph(
    startDestination: KClass<*>,
    navHostController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination,
    ) {
        TemplateDestination.composable(
            navGraphBuilder = this,
            navScope = object : TemplateNavScope {
                override val navigateToTemplateScreen: () -> Unit = { navHostController.navigate(TemplateFeatureDestination) }
            },
        )

        TemplateFeatureDestination.composable(
            navGraphBuilder = this,
            navScope = object : TemplateFeatureNavScope {},
        )
    }
}

@Composable
fun TemplateScreen(
    uiState: TemplateUiState,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
    ) {
        Button(onClick = uiState.onFetchClicked) {
            Text(text = "Fetch test")
        }
        Button(onClick = uiState.onNavigateClicked) {
            Text(text = "Navigate test")
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            items(
                items = uiState.uuid,
            ) { id ->
                Text(text = id)
            }
        }
    }
}
