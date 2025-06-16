package template.app

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinViewModel

@Serializable
object TemplateDestination {
    fun composable(navGraphBuilder: NavGraphBuilder, navScope: TemplateNavScope) {
        navGraphBuilder.composable<TemplateDestination> {
            val presenter: TemplatePresenter = koinViewModel()
            presenter.invoke(navScope)
        }
    }
}
