package `fun`.kulikov.aviasalestestapp.data.api

import `fun`.kulikov.aviasalestestapp.data.destination.cloud.model.DestinationJson
import retrofit2.http.GET
import retrofit2.http.Query

interface DestinationService {

    //Destination
    //region

    @GET("autocomplete")
    suspend fun getDestination(
        @Query("term") name: String,
        @Query("lang") lang: String = "ru"
    ): DestinationJson

    //endregion

}