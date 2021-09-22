package udacity.project.shoesstoreapp.presentation.shoeslist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import udacity.project.shoesstoreapp.model.Shoes

class ShoesListFragmentVM : ViewModel(){
    companion object {
        private const val LOG_TAG = "ShoesListFragmentVM"
    }


//--------------------------- Live Data -----------------------------------------------------------


    // The whole list of the shoes.
    private val _shoesList = MutableLiveData<Shoes>()
    val shoesList: LiveData<Shoes>
        get() = _shoesList


//--------------------------- Initialization ------------------------------------------------------

    init {
        Log.i(LOG_TAG, "Shoes List Fragment View model create.")
        initShoesList()
    }


//--------------------------- List Function -------------------------------------------------------


    /** Initialization the shoes list at the beginning. */
    private fun initShoesList() {

    }

    /** The function is used to add new shoes into the list. */
    private fun addShoes() {

    }


//--------------------------- Life Cycle Function -------------------------------------------------


    /** Lifecycle function */
    override fun onCleared() {
        super.onCleared()
        Log.i(LOG_TAG, "onCleared(): run")
    }
}