package udacity.project.shoesstoreapp.presentation.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import udacity.project.shoesstoreapp.R
import udacity.project.shoesstoreapp.databinding.FragmentWelcomeBinding

/**
 * The Fragment Class is used to construct a welcome screen.
 *
 * @See Fragment
 * */
class WelcomeFragment : Fragment() {


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
    ): View? {
        val binding: FragmentWelcomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        binding.instructionBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_welcomeFragment_to_instructionFragment))
        // Inflate the layout for this fragment
        return binding.root
    }
}