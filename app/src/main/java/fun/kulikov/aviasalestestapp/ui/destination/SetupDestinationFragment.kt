package `fun`.kulikov.aviasalestestapp.ui.destination

import `fun`.kulikov.aviasalestestapp.R
import `fun`.kulikov.aviasalestestapp.databinding.FragmentSetupDestinationBinding
import `fun`.kulikov.aviasalestestapp.ui.base.BaseFragment
import androidx.fragment.app.viewModels

class SetupDestinationFragment : BaseFragment(R.layout.fragment_setup_destination) {

    private val viewModel by viewModels<SetupDestinationViewModel>()
    private val adapter by lazy { SetupDestinationRvAdapter() }

    override fun setup() {
        (binding as FragmentSetupDestinationBinding).apply {
            viewmodel = viewModel
            lifecycleOwner = this@SetupDestinationFragment
            rvAdapter = adapter
        }
    }

}