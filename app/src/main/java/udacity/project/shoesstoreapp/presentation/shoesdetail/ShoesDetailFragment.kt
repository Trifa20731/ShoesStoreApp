package udacity.project.shoesstoreapp.presentation.shoesdetail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import udacity.project.shoesstoreapp.MainActivityVM
import udacity.project.shoesstoreapp.R
import udacity.project.shoesstoreapp.databinding.FragmentShoesDetailBinding
import udacity.project.shoesstoreapp.model.Shoes

class ShoesDetailFragment : Fragment() {

    companion object {
        const val LOG_TAG = "ShoesDetailFragment"
    }

    // Binding Object for the shoesDetailFragment.
    // Name of the object is derived from the name of the activity or fragment.
    private lateinit var binding: FragmentShoesDetailBinding

    /* We create an instance of MainViewModel using specific KTX-Fragments extension to
     * tell the program that we are willing to use the instance of the Activity this fragment is attached to. */
    private val sharedVM: MainActivityVM by activityViewModels()
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
     */
    private fun cancelShoesAdd(view: View) {
        view.findNavController().navigate(R.id.action_shoesDetailFragment_to_shoesListFragment)
    }

    /**
     * Click handler for the Cancel button.
     * TODO: Handle the empty input case.
     */
    private fun saveShoesAdd(view: View) {
        binding.apply {
            shoes?.name = shoesNameET.text.toString()
            shoes?.company = shoesCompanyET.text.toString()
            shoes?.size = shoesSizeET.text.toString()
            shoes?.description = shoesDescriptionET.text.toString()
        }
        sharedVM.addShoes(shoes)
        view.findNavController().navigate(R.id.action_shoesDetailFragment_to_shoesListFragment)
    }
}