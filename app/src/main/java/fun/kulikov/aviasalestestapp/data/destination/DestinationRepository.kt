package `fun`.kulikov.aviasalestestapp.data.destination

import `fun`.kulikov.aviasalestestapp.data.api.ApiController
import `fun`.kulikov.aviasalestestapp.data.destination.cloud.DestinationCloudDataSource
import `fun`.kulikov.aviasalestestapp.data.destination.cloud.DestinationCloudDataSourceImpl
import `fun`.kulikov.aviasalestestapp.domain.destination.DestinationBusiness
import javax.inject.Inject
import javax.inject.Singleton

interface DestinationRepository {
    suspend fun getDestinationsList(name: String) : List<DestinationBusiness>
}

/**
 * По клину должно быть синглтоном, в будущем помимо cloudDataSource можно пихнуть
 * cacheDataSource, так как и первый и второй источник данных возвращает бизнес - модель,
 * можно будет не переписывать весь код в бизнес слое
 * */
@Singleton
class DestinationRepositoryImpl @Inject constructor(
    private val apiController: ApiController,
    private val cloudDataSource: DestinationCloudDataSource =
        DestinationCloudDataSourceImpl(apiController)
) : DestinationRepository {

    override suspend fun getDestinationsList(name: String) : List<DestinationBusiness> =
        cloudDataSource.getDestinationsList(name)

}