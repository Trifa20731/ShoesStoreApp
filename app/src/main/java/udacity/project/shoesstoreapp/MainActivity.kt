package udacity.project.shoesstoreapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import udacity.project.shoesstoreapp.databinding.ActivityMainBinding

/**
 * This class has the UI logic of the main activity.
 *
 * @see AppCompatActivity
 * */
class MainActivity : AppCompatActivity() {

    // Binding and Navigation Parameter Declaration.
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var binding: ActivityMainBinding

    // Initializing the viewModel on call using KTX-Fragments extension.
    private val viewModel: MainActivityVM by viewModels()

    /**
     * onCreate to initialize the activity when activity is first create.
     *
     * @param savedInstanceState is a mapping from String keys to various Parcelable values.
     * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Data Binding Assigning.
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        // Fragment Host Navigation Assigning.
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.myNavHostFragment) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    /**
     * This method is called whenever the user chooses to navigate Up within your application's
     * activity hierarchy from the action bar.
     *
     * @return true if Up navigation completed successfully and this Activity was finished,
     *         false otherwise.
     * */
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}