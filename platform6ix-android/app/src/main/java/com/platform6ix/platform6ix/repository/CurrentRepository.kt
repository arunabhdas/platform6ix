package com.platform6ix.platform6ix.repository

import com.platform6ix.platform6ix.model.CurrentWeatherResponse
import com.platform6ix.platform6ix.util.ApiHelper
import kotlinx.coroutines.Deferred

/**
 * Created by Das on 2021-08-27.
 */


class CurrentRepository(private val apiHelper: ApiHelper) {
    fun fetchCurrentWeather(): Deferred<CurrentWeatherResponse> {
        return apiHelper.fetchCurrentWeather()
    }
}