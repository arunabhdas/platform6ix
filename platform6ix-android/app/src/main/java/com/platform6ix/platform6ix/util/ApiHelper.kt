package com.platform6ix.platform6ix.util

import com.platform6ix.platform6ix.services.WeatherService

/**
 * Created by Das on 2021-08-27.
 */
class ApiHelper(private val weatherService: WeatherService) {

    fun getCurrentWeather() = weatherService.getCurrentWeather("Miami", "en")

}