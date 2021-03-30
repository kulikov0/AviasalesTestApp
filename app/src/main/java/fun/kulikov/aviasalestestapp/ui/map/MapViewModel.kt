package `fun`.kulikov.aviasalestestapp.ui.map

import `fun`.kulikov.aviasalestestapp.ui.base.BaseViewModel
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.maps.model.LatLng

class MapViewModel : BaseViewModel() {

    val locations: MutableLiveData<List<LatLng>> = MutableLiveData()

    fun onBackPressed() = navigationController.onBackPressed()

}