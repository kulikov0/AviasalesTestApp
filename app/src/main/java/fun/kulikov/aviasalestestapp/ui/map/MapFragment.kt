package `fun`.kulikov.aviasalestestapp.ui.map

import `fun`.kulikov.aviasalestestapp.R
import `fun`.kulikov.aviasalestestapp.databinding.FragmentMapBinding
import `fun`.kulikov.aviasalestestapp.ui.base.BaseFragment
import `fun`.kulikov.aviasalestestapp.utils.lifecycle.FragmentLifecycleObserver
import android.os.Bundle
import androidx.fragment.app.viewModels
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.model.LatLng

class MapFragment : BaseFragment(R.layout.fragment_map) {

    companion object {

        private const val ARG_LOCATIONS = "ARG_LOCATIONS"

        fun newInstance(locations: List<LatLng>) = MapFragment().apply {
            arguments = Bundle().apply {
                putParcelableArrayList(ARG_LOCATIONS, ArrayList(locations))
            }
        }

    }

    private val viewModel by viewModels<MapViewModel>()

    private val locations: List<LatLng>
        get() = arguments?.getParcelableArrayList(ARG_LOCATIONS)!!

    override fun setup() {
        FragmentLifecycleObserver.registerLifecycle(lifecycle)
        (binding as FragmentMapBinding).apply {
            with(map) {
                onCreate(null)
                MapsInitializer.initialize(context)

            }
            viewmodel = viewModel.apply {
                locations.postValue(this@MapFragment.locations)
            }
            lifecycleOwner = this@MapFragment
        }

    }

}