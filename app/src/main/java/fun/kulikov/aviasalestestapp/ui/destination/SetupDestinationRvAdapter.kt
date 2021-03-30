package `fun`.kulikov.aviasalestestapp.ui.destination

import `fun`.kulikov.aviasalestestapp.R
import `fun`.kulikov.aviasalestestapp.domain.destination.DestinationBusiness
import `fun`.kulikov.aviasalestestapp.ui.base.BaseRvAdapter
import androidx.recyclerview.widget.DiffUtil

class SetupDestinationRvAdapter(
    private val diffUtil: SetupDestinationDIffUtil = SetupDestinationDIffUtil()
) : BaseRvAdapter<DestinationBusiness>() {

    override fun updateData(list: List<DestinationBusiness>) {
        val diff = DiffUtil.calculateDiff(diffUtil.apply {
            setItems(items, list)
        })
        items = list.toMutableList()
        diff.dispatchUpdatesTo(this)
    }

    override fun getItemResId(viewType: Int): Int = R.layout.item_destination

}