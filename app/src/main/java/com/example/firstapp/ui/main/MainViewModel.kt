package com.example.firstapp.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstapp.R
import com.example.firstapp.model.Hewan
import com.example.firstapp.network.HewanApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val data = MutableLiveData<List<Hewan>>()
    private val status = MutableLiveData<HewanApi.ApiStatus>()
    init {
        retrieveData()
    }
    private fun retrieveData() {
        viewModelScope.launch (Dispatchers.IO) {
            status.postValue(HewanApi.ApiStatus.LOADING)
            try {
                data.postValue(HewanApi.service.getHewan())
                status.postValue(HewanApi.ApiStatus.SUCCESS)
            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
                status.postValue(HewanApi.ApiStatus.FAILED)

            }
        }
    }
    fun getData(): LiveData<List<Hewan>> = data
    fun getStatus(): LiveData<HewanApi.ApiStatus> = status
}