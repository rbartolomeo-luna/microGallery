package template.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinViewModel

@Serializable
object TemplateFeatureDestination {
    fun composable(navGraphBuilder: NavGraphBuilder, navScope: TemplateFeatureNavScope) {
        navGraphBuilder.composable<TemplateFeatureDestination> {
            val presenter: TemplateFeaturePresenter = koinViewModel()
            presenter.invoke(navScope)
        }
    }
}
