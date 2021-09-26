package udacity.project.shoesstoreapp.presentation.shoesdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import udacity.project.shoesstoreapp.R
import udacity.project.shoesstoreapp.databinding.FragmentShoesDetailBinding
import udacity.project.shoesstoreapp.model.Shoes

class ShoesDetailFragment : Fragment() {

    // Binding Object for the shoesDetailFragment.
    // Name of the object is derived from the name of the activity or fragment.
    private lateinit var binding: FragmentShoesDetailBinding

    // Instance of Shoes data class.
    private val shoes: Shoes = Shoes()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Binding object for ShoesDetailFragment.
        // Name of the object is derived from the name of the activity or fragment.
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoes_detail, container, false)

        // Set the value of the shoes variable that is declared and used in the layout file.
        binding.shoes = shoes

        // Set On Click Listener.
        binding.cancelButton.setOnClickListener { cancelShoesAdd(it) }
        binding.saveButton.setOnClickListener { saveShoesAdd(it) }

        return binding.root
    }


//--------------------------------------------------------- Click Handler --------------------------------------------------------------------------------------


    /**
     * Click handler for the Cancel button.
     *     -- There is no any arguments will send back to the list when user click the cancel button.
     */
    private fun cancelShoesAdd(view: View) {
        view.findNavController()
            .navigate(ShoesDetailFragmentDirections.actionShoesDetailFragmentToShoesListFragment(null, null, null, null))
    }

    /**
     * Click handler for the Cancel button.
     *     -- There are some arguments will send back to list fragment when use click save button.
     *         -- Shoes Name, Shoes Company, Shoes Size, Shoes Description
     *     -- The shoes should be the safe type.
     */
    private fun saveShoesAdd(view: View) {
        binding.apply {
            shoes?.name = shoesNameET.text.toString()
            shoes?.company = shoesCompanyET.text.toString()
            shoes?.size = shoesSizeET.text.toString()
            shoes?.description = shoesDescriptionET.toString()
        }
        view.findNavController()
            .navigate(ShoesDetailFragmentDirections.actionShoesDetailFragmentToShoesListFragment(shoes.name, shoes.company, shoes.size, shoes.description))
    }
}