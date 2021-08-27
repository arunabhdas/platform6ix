package com.platform6ix.platform6ix.services

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.platform6ix.platform6ix.model.CurrentWeatherResponse
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Das on 2021-08-26.
 */
const val API_KEY = "7c0e16b199f4e835e5fbb0fe03f7319c"
const val BASE_URL = " http://api.weatherstack.com/"

// http://api.weatherstack.com/current?access_key=7c0e16b199f4e835e5fbb0fe03f7319c&query=Toronto

interface RetrofitService {

    @GET("current")
    fun getCurrentWeather(
        @Query("query") location: String,
        @Query("lang") languageCode: String = "en"
    ): Deferred<CurrentWeatherResponse>

    companion object {
        operator fun invoke(): RetrofitService {
            val requestInterceptor = Interceptor { chain ->
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("access_key", API_KEY)
                    .build()

                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)

            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitService::class.java)
        }
    }
}

