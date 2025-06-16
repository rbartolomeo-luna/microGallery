package template.shared

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.binds
import org.koin.dsl.module
import template.domain.FetchTemplateUseCase
import template.domain.GetAllTemplateUseCase
import template.domain.GetTemplateFeatureUseCase
import template.local.RoomAppDatabase
import template.local.TemplateLocalDatasource
import template.local.TemplateLocalDatasourceImpl
import template.local.buildRoomDatabase
import template.remote.CoreHttpClient
import template.remote.KtorTemplateClient
import template.remote.TemplateRemoteDatasource
import template.remote.TemplateRemoteDatasourceImpl
import template.repository.TemplateRepository
import template.repository.TemplateFeatureRepository

object KoinHelper {
    fun init(block: KoinApplication.() -> Unit) {
        startKoin {
            modules(
                PlatformSpecificModule,
                LocalModule,
                RemoteModule,
                RepositoryModule,
                DomainModule,
            )
            block()
        }
    }
}

expect val PlatformSpecificModule: Module

private val LocalModule: Module = module {
    single<RoomAppDatabase> { buildRoomDatabase(builder = get(), context = Dispatchers.IO) }
    single { get<RoomAppDatabase>().templateDao() }
    factoryOf(::TemplateLocalDatasourceImpl).binds(arrayOf(TemplateLocalDatasource::class))
}

private val RemoteModule: Module = module {
    single { CoreHttpClient(baseUrl = "https://www.uuidtools.com/api/") }
    factoryOf(::KtorTemplateClient)
    factoryOf(::TemplateRemoteDatasourceImpl).binds(arrayOf(TemplateRemoteDatasource::class))
}

private val RepositoryModule: Module = module {
    factoryOf(::TemplateRepository)
    factoryOf(::TemplateFeatureRepository)
}

private val DomainModule: Module = module {
    factoryOf(::FetchTemplateUseCase)
    factoryOf(::GetAllTemplateUseCase)
    factoryOf(::GetTemplateFeatureUseCase)
}
