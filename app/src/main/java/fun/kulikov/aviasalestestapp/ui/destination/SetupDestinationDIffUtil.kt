package `fun`.kulikov.aviasalestestapp.ui.destination

import `fun`.kulikov.aviasalestestapp.domain.destination.DestinationBusiness
import `fun`.kulikov.aviasalestestapp.utils.animations.BaseDiffCallback

class SetupDestinationDIffUtil : BaseDiffCallback<DestinationBusiness>() {

    override fun areItemsTheSame(
        oldItem: DestinationBusiness,
        newItem: DestinationBusiness
    ): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(
        oldItem: DestinationBusiness,
        newItem: DestinationBusiness
    ): Boolean {
        return true
    }

}