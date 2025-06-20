package studio.lunabee.microgallery.android.remote.datasource

import studio.lunabee.microgallery.android.domain.Node
import studio.lunabee.microgallery.android.remote.service.RootService
import studio.lunabee.microgallery.android.repository.datasource.remote.TreeRemoteDatasource

class TreeRemoteDatasourceImpl(
    private val rootService: RootService
) : TreeRemoteDatasource{
    override suspend fun fetchRoot() : Node {
        return rootService.fetchRootList()[0].toData()
    }
}
