package com.example.flagshw.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flagshw.network.FlagApi
import com.example.flagshw.network.FlagPhoto
import com.example.flagshw.network.Photo
import kotlinx.coroutines.launch
import java.lang.Exception

class FlagViewModel : ViewModel() {

    private var _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    init {
        Log.d("init", "inside init")
        getFlagPhotos()
    }

    private fun getFlagPhotos(){

        viewModelScope.launch {
        try {
            Log.d("getFlagPhotos","().data\n" +
                    "            _status.value = \"Success: ")
            val listResult = FlagApi.retrofitService.getPhotos().data
            _status.value = "Success: ${listResult[0].flagUrl} Flags photos retrieved"
        }catch (e: Exception){
            _status.value = "Failure: ${e.message}"
        }

        }


    }
  }