package udacity.project.shoesstoreapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import udacity.project.shoesstoreapp.model.Shoes

class MainActivityVM : ViewModel() {
    companion object {
        private const val LOG_TAG = "MainActivityVM"
    }


//--------------------------- Live Data -----------------------------------------------------------


    // The whole list of the shoes.
    private val _shoesList = MutableLiveData<ArrayList<Shoes>>()
    val shoesList: LiveData<ArrayList<Shoes>>
        get() = _shoesList


//--------------------------- Initialization ------------------------------------------------------


    init {
        Log.i(LOG_TAG, "Main Activity View Model create.")
    }


//--------------------------- List Function -------------------------------------------------------


    /** The function is used to add new shoes into the list. */
    fun addShoes() {
        Log.i(LOG_TAG, "addShoes(): run.")
        Log.i(LOG_TAG, "The shoes list isEmpty?")
    }


//--------------------------- Life Cycle Function -------------------------------------------------


    /** Lifecycle function */
    override fun onCleared() {
        super.onCleared()
        Log.i(LOG_TAG, "onCleared(): run")
    }


}