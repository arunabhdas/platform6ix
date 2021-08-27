package com.platform6ix.platform6ix.repository

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import com.platform6ix.platform6ix.model.CurrentWeatherResponse
import com.platform6ix.platform6ix.services.CurrentWeatherDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.ZonedDateTime

/**
 * Created by Das on 2021-08-27.
 */

class CurrentWeatherRepository(
  private val currentWeatherDataSource: CurrentWeatherDataSource
) {

    suspend fun getCurrentWeather() = currentWeatherDataSource.downloadedCurrentWeather

}