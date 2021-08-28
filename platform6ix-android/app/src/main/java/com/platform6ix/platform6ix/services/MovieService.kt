package com.platform6ix.platform6ix.services

import com.platform6ix.platform6ix.model.MoviesResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Das on 2021-08-27.
 */


interface MovieService {

 @GET("movie/popular")
 fun fetchPopularMoviesAsync(): Deferred<Response<MoviesResponse>>

 @GET("search/movie")
 fun fetchMovieByQueryAsync(@Query("query") query: String): Deferred<Response<MoviesResponse>>
}