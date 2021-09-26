package udacity.project.shoesstoreapp.presentation.shoeslist

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import udacity.project.shoesstoreapp.R
import udacity.project.shoesstoreapp.databinding.FragmentShoesListBinding

class ShoesListFragment : Fragment() {

    private lateinit var binding: FragmentShoesListBinding
    private lateinit var args: ShoesListFragmentArgs


//--------------------------------------------------------- OnCreate View Function -----------------------------------------------------------------------------


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Use the view binding to connect view and model.
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoes_list, container, false)
        binding.addNewShoesDetailFloatingABtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoesListFragment_to_shoesDetailFragment))

        // Check the arguments sending from other fragment, add the data into view model.
        args = ShoesListFragmentArgs.fromBundle(requireArguments())

        // Set the menu for sign out and about page.
        setHasOptionsMenu(true)

        // Inflate the layout for this fragment
        return binding.root
    }


//--------------------------------------------------------- Menu Related Functions -----------------------------------------------------------------------------


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.infor_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }


}