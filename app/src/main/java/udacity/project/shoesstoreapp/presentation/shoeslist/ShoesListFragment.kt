package udacity.project.shoesstoreapp.presentation.shoeslist

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import org.w3c.dom.Text
import udacity.project.shoesstoreapp.MainActivityVM
import udacity.project.shoesstoreapp.R
import udacity.project.shoesstoreapp.databinding.FragmentShoesListBinding
import udacity.project.shoesstoreapp.model.Shoes

class ShoesListFragment : Fragment() {

    companion object {
        private const val LOG_TAG = "ShoesListFragment"
    }

    private lateinit var binding: FragmentShoesListBinding

    /* We create an instance of MainViewModel using specific KTX-Fragments extension to
     * tell the program that we are willing to use the instance of the Activity this fragment is attached to. */
    private val sharedVM: MainActivityVM by activityViewModels()

//--------------------------------------------------------- OnCreate View Function -----------------------------------------------------------------------------

    /** The method is used to draw the layout the fragment. */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Use the view binding to connect view and model.
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoes_list, container, false)
        binding.addNewShoesDetailFloatingABtn.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                R.id.action_shoesListFragment_to_shoesDetailFragment
            )
        )

        // Set the menu for sign out and about page.
        setHasOptionsMenu(true)

        // Inflate the layout for this fragment
        return binding.root
    }

    /** The method will execute after drawing the element on the fragment. */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedVM.shoesList.observe(viewLifecycleOwner, Observer { updateShoesList(it) })
    }

//--------------------------- Menu Related Functions -----------------------------------------------


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.infor_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }


//--------------------------- Update the shoes list UI ---------------------------------------------


    private fun updateShoesList(shoesList: ArrayList<Shoes>) {
        if (shoesList.isNotEmpty()) {
            binding.shoesListItemContainerLL.removeAllViews()
            // Add the view.
            for (shoesItem in shoesList) {
                val inflater = LayoutInflater.from(context).inflate(R.layout.list_item_shoes, null)
                binding.shoesListItemContainerLL.addView(
                    inflater,
                    binding.shoesListItemContainerLL.childCount
                )
            }

            val count = binding.shoesListItemContainerLL.childCount
            var v: View?
            for (i in 0 until count) {
                v = binding.shoesListItemContainerLL.getChildAt(i)
                val shoesNameTV: TextView = v.findViewById(R.id.shoesNameTV)
                val shoesCompanyTV: TextView = v.findViewById(R.id.shoesCompanyTV)
                val shoesSizeTV: TextView = v.findViewById(R.id.shoesSizeTV)
                val shoesDescriptionTV: TextView = v.findViewById(R.id.shoesDescriptionTV)
                shoesNameTV.text = shoesList[i].name
                shoesCompanyTV.text = shoesList[i].company
                shoesSizeTV.text = shoesList[i].size
                shoesDescriptionTV.text = shoesList[i].description
            }
        }
    }
}