package `fun`.kulikov.aviasalestestapp.domain.destination

import com.google.android.gms.maps.model.LatLng

data class DestinationBusiness(
    val name: String,
    val latLng: LatLng
)