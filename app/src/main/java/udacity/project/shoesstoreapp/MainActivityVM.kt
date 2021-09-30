package udacity.project.shoesstoreapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import udacity.project.shoesstoreapp.model.Shoes

/**
 * The View Model is used to store the data in the main activity.
 *
 * @see ViewModel
 * */

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

    /**
     * The Initialization block, create an empty shoes list.
     * */
    init {
        Log.i(LOG_TAG, "Main Activity View Model create.")
        _shoesList.value = ArrayList<Shoes>()
    }


//--------------------------- List Function -------------------------------------------------------


    /**
     * The function is used to add new shoes into the list.
     *
     * @param shoes The shoes object which will be added to the list.
     * */
    fun addShoes(shoes: Shoes) {
        _shoesList.value?.add(shoes)
    }


//--------------------------- Life Cycle Function -------------------------------------------------


    /**
     * This method will be called when this ViewModel is no longer used and will be destroyed.
     * */
    override fun onCleared() {
        super.onCleared()
        Log.i(LOG_TAG, "onCleared(): run")
    }


}