package com.platform6ix.platform6ix.data.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by Das on 2022-02-06.
 */
data class Location(
    val country: String,
    val lat: String,
    val localtime: String,
    @SerializedName("localtime_epoch")
    val localtimeEpoch: Int,
    val lon: String,
    val name: String,
    val region: String,
    @SerializedName("timezone_id")
    val timezoneId: String,
    @SerializedName("utc_offset")
    val utcOffset: String
)
