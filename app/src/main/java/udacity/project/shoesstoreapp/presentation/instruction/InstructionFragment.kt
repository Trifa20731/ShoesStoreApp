package udacity.project.shoesstoreapp.presentation.instruction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import udacity.project.shoesstoreapp.R
import udacity.project.shoesstoreapp.databinding.FragmentInstructionBinding

/**
 * The Fragment Class is used to construct a instruction screen.
 *
 * @See Fragment
 * */
class InstructionFragment : Fragment() {


    /**
     * Called to have the fragment instantiate its user interface view.
     *
     * @param inflater The LayoutInflater object that can be used to inflate any views in the fragment
     * @param container  If non-null, this is the parent view that the fragment's UI should be attached to.
     * @param savedInstanceState  If non-null, this fragment is being re-constructed from a previous saved state as given here.
     *
     * @return the View for the fragment's UI, or null.
     * */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentInstructionBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_instruction, container, false)
        binding
            .shoesListBtn
            .setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_instructionFragment_to_shoesListFragment))
        return binding.root
    }

}