package `fun`.kulikov.aviasalestestapp.data.destination.cloud.mappers

import `fun`.kulikov.aviasalestestapp.data.destination.cloud.model.CityJson
import `fun`.kulikov.aviasalestestapp.data.destination.cloud.model.DestinationJson
import `fun`.kulikov.aviasalestestapp.data.destination.cloud.model.HotelJson
import `fun`.kulikov.aviasalestestapp.data.destination.cloud.model.LocationJson
import `fun`.kulikov.aviasalestestapp.domain.destination.DestinationBusiness
import `fun`.kulikov.aviasalestestapp.utils.mapping.Mapper
import com.google.android.gms.maps.model.LatLng

class DestinationJsonToBusinessMapper(
    private val cityToBusinessMapper: Mapper<CityJson, DestinationBusiness> = CityJsonToDestinationBusinessMapper(),
) : Mapper<DestinationJson, List<DestinationBusiness>> {

    override fun map(from: DestinationJson): List<DestinationBusiness> {
        return mutableListOf<DestinationBusiness>().apply {
            from.cities?.map(cityToBusinessMapper::map)?.let(this::addAll)
        }
    }

}

class CityJsonToDestinationBusinessMapper(
    private val latLngMapper: Mapper<LocationJson?, LatLng> = LocationJsonToBusinessMapper()
) : Mapper<CityJson, DestinationBusiness> {

    override fun map(from: CityJson): DestinationBusiness {
        return DestinationBusiness(
            name = from.fullName ?: "",
            latLng = latLngMapper.map(from.location)
        )
    }

}

class LocationJsonToBusinessMapper : Mapper<LocationJson?, LatLng> {

    override fun map(from: LocationJson?): LatLng {
        return LatLng(
            from?.lat ?: 0.0,
            from?.lon ?: 0.0
        )
    }

}