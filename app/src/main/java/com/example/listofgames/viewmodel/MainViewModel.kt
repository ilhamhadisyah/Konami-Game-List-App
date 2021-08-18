package com.example.listofgames.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.listofgames.data.source.retrofit.ApiHelper
import com.example.listofgames.networkutils.Resources
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val apiHelper: ApiHelper): ViewModel() {

    fun getGamesData() = liveData(Dispatchers.IO) {
        emit(Resources.loading(data = null))
        try {
            emit(Resources.success(data = apiHelper.getGamesData()))
            Log.d("response","success")
        } catch (e: Exception) {
            emit(Resources.error(data = null, message = e.message ?: "Error ocurred"))
            Log.d("response",e.message.toString())
        }
    }
}