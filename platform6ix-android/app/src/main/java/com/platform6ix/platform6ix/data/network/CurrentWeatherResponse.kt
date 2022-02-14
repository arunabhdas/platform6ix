package com.platform6ix.platform6ix.model

import com.google.gson.annotations.SerializedName
import com.platform6ix.platform6ix.data.entity.CurrentWeatherEntry
import com.platform6ix.platform6ix.data.entity.Location


data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    val location: Location,
    val request: Request
)



data class Request(
    val language: String,
    val query: String,
    val type: String,
    val unit: String
)