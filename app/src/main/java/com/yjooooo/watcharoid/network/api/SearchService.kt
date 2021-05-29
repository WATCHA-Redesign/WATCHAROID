package com.yjooooo.watcharoid.network.api

import retrofit2.http.GET

interface SearchService {
    @GET("searchpage/popular")
    fun getPopularSearch()
    @GET("searchpage/collection")
    fun getWatchaCollection()
    @GET("searchpage/mate")
    fun getMovieMate()
}