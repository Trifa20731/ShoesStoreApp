package udacity.project.shoesstoreapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import udacity.project.shoesstoreapp.model.Shoes

/** The View Model is used to store the data in the main activity. */
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

    /** The Initialization block */
    init {
        Log.i(LOG_TAG, "Main Activity View Model create.")
        _shoesList.value = ArrayList<Shoes>()
    }


//--------------------------- List Function -------------------------------------------------------


    /** The function is used to add new shoes into the list. */
    fun addShoes(shoes: Shoes) {
        _shoesList.value?.add(shoes)
    }


//--------------------------- Life Cycle Function -------------------------------------------------


    /** Lifecycle function */
    override fun onCleared() {
        super.onCleared()
        Log.i(LOG_TAG, "onCleared(): run")
    }


}