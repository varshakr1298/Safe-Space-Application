package com.example.mentalhealth

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mentalhealth.database.Post
import com.example.mentalhealth.database.PostDatabaseDao
import kotlinx.coroutines.*

class DiscussionViewModel(val database: PostDatabaseDao, application: Application) : AndroidViewModel(application) {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private val _dataChanged = MutableLiveData<Boolean>()
    val dataChanged: LiveData<Boolean>
    get() = _dataChanged

    init{
        _dataChanged.value = true
    }

    fun addItem(newOrder: Post){
        uiScope.launch {
            insert(newOrder)
        }
    }

    private suspend fun insert(order: Post){
        withContext(Dispatchers.IO){
            database.insert(order)
            Log.i("Database", "ItemAdded")
        }
    }

    fun onClear(){
        uiScope.launch {
            clear()
        }
    }

    private suspend fun clear(){
        withContext(Dispatchers.IO){
            database.clear()
            Log.i("Database", "All values deleted")
        }
    }

fun dataCannotChanged(){
   _dataChanged.value = false
}

    fun dataCanChanged(){
        _dataChanged.value = true
    }

    }
