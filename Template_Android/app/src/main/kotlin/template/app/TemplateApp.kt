package template.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import template.ui.TemplateFeaturePresenter
import template.shared.KoinHelper

class TemplateApp : Application() {
    override fun onCreate() {
        super.onCreate()
        KoinHelper.init {
            androidContext(this@TemplateApp)
            modules(
                module {
                    viewModelOf(::TemplateFeaturePresenter)
                    viewModelOf(::TemplatePresenter)
                },
            )
        }
    }
}
