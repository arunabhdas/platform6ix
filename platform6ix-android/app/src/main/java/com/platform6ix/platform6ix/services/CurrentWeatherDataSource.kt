package com.platform6ix.platform6ix.services

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.platform6ix.platform6ix.model.CurrentWeatherResponse
import com.platform6ix.platform6ix.network.NoConnectivityException

/**
 * Created by Das on 2021-08-27.
 */
interface CurrentWeatherDataSource {
  val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>

  suspend fun fetchCurrentWeather(
    location: String,
    languageCode: String
  )
}

class CurrentWeatherDataSourceImpl(
  private val weatherService: WeatherService
) : CurrentWeatherDataSource {
  private val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()
  override val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
    get() = _downloadedCurrentWeather

  override suspend fun fetchCurrentWeather(location: String, languageCode: String) {
    try {
      val fetchedCurrentWeather = weatherService
        .getCurrentWeather(location, languageCode)
        .await()
      _downloadedCurrentWeather.postValue(fetchedCurrentWeather)
    }
    catch (e: NoConnectivityException) {
      Log.e("Connectivity", "No internet connection")
    }

  }
}