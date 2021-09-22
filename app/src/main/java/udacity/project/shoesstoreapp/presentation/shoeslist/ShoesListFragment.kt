package udacity.project.shoesstoreapp.presentation.shoeslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import udacity.project.shoesstoreapp.R
import udacity.project.shoesstoreapp.databinding.FragmentShoesListBinding

class ShoesListFragment : Fragment() {

    private lateinit var viewModel: ShoesListFragmentVM
    private lateinit var binding: FragmentShoesListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Loading the viewmodel to the fragment.
        viewModel = ViewModelProvider(this).get(ShoesListFragmentVM::class.java)

        // Use the view binding to connect view and model.
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoes_list, container, false)
        binding.shoesListItemsTV.text = viewModel.shoesList.toString()
        binding.addNewShoesDetailFloatingABtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoesListFragment_to_shoesDetailFragment))


        // Inflate the layout for this fragment
        return binding.root
    }

}