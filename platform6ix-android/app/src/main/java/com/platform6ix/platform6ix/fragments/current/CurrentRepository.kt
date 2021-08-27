package com.platform6ix.platform6ix.fragments.current

import com.platform6ix.platform6ix.services.RetrofitService

/**
 * Created by Das on 2021-08-26.
 */
class CurrentRepository constructor(private val retrofitService: RetrofitService){
    suspend fun getCurrentWeather() = retrofitService.getCurrentWeather("Miami", "en")
}