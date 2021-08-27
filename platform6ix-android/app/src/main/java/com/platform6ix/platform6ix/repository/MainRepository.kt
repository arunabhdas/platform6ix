package com.platform6ix.platform6ix.repository

import com.platform6ix.platform6ix.services.RetrofitService

/**
 * Created by Das on 2021-08-26.
 */
class MainRepository constructor(private val retrofitService: RetrofitService){
    suspend fun getCurrentWeather() = retrofitService.getCurrentWeather("Miami", "en")
}