package com.platform6ix.platform6ix.fragments.current

import com.platform6ix.platform6ix.services.WeatherService

/**
 * Created by Das on 2021-08-26.
 */
class CurrentRepository constructor(private val weatherService: WeatherService){
    suspend fun getCurrentWeather() = weatherService.getCurrentWeather("Miami", "en")
}