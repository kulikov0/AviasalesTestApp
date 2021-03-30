package `fun`.kulikov.aviasalestestapp.utils.navigation

import `fun`.kulikov.aviasalestestapp.ui.destination.SetupDestinationFragment
import `fun`.kulikov.aviasalestestapp.ui.map.MapFragment
import `fun`.kulikov.aviasalestestapp.utils.animations.CustomTransactions
import `fun`.kulikov.aviasalestestapp.utils.animations.StandardTransition
import com.google.android.gms.maps.model.LatLng

class NavigationController : BaseNavigationController() {

    companion object {
        private lateinit var instance: NavigationController

        fun getInstance(): NavigationController {
            if (!this::instance.isInitialized) {
                instance = NavigationController()
            }
            return instance
        }
    }

    fun openSetupDestinationFragment() =
        newFlow(SetupDestinationFragment(), StandardTransition.open())

    fun openMapFragment(locations: List<LatLng>) = addFragment(
        MapFragment.newInstance(locations), animation =  CustomTransactions.slideFromLeft()
    )

}