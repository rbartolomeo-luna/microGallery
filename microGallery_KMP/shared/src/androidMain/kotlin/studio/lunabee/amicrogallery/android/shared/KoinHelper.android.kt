package studio.lunabee.amicrogallery.android.shared

import org.koin.core.module.Module
import org.koin.dsl.module
import studio.lunabee.amicrogallery.android.local.RoomPlatformBuilder

actual val PlatformSpecificModule: Module = module {
    single<RoomPlatformBuilder> { RoomPlatformBuilder(context = get()) }
}
