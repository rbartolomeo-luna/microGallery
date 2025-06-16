package studio.lunabee.amicrogallery.android.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import studio.lunabee.amicrogallery.android.shared.KoinHelper

class microGalleryApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KoinHelper.init {
            androidContext(this@microGalleryApplication)
        }
    }
}
