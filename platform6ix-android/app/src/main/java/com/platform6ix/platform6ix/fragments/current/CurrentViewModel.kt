package com.platform6ix.platform6ix.fragments.current

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.platform6ix.platform6ix.model.CurrentWeatherResponse
import kotlinx.coroutines.*

class CurrentViewModel() : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val currentWeather = MutableLiveData<CurrentWeatherResponse>()
    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }
    val loading = MutableLiveData<Boolean>()
    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }

    fun getCurrentWeather() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
        }
    }


    val text: LiveData<String> = _text

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}