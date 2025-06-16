package template.shared

import org.koin.core.module.Module
import org.koin.dsl.module
import template.local.RoomPlatformBuilder

actual val PlatformSpecificModule: Module = module {
    single<RoomPlatformBuilder> { RoomPlatformBuilder(context = get()) }
}
