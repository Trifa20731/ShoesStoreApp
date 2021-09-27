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

class InstructionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
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