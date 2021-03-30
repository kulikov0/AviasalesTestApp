package `fun`.kulikov.aviasalestestapp.data.destination.cloud

import `fun`.kulikov.aviasalestestapp.data.api.ApiController
import `fun`.kulikov.aviasalestestapp.data.destination.cloud.mappers.DestinationJsonToBusinessMapper
import `fun`.kulikov.aviasalestestapp.data.destination.cloud.model.DestinationJson
import `fun`.kulikov.aviasalestestapp.domain.destination.DestinationBusiness
import `fun`.kulikov.aviasalestestapp.utils.mapping.Mapper
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

interface DestinationCloudDataSource {
    suspend fun getDestinationsList(name: String) : List<DestinationBusiness>
}

class DestinationCloudDataSourceImpl(
    private val apiController: ApiController,
    private val mapper: Mapper<DestinationJson, List<DestinationBusiness>> = DestinationJsonToBusinessMapper()
) : DestinationCloudDataSource {

    override suspend fun getDestinationsList(name: String) : List<DestinationBusiness> {
        return withContext(IO) {
            mapper.map(
                apiController.destinationService.getDestination(name)
            )
        }
    }

}
