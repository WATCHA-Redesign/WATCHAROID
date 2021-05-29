package com.yjooooo.watcharoid.network.api

import retrofit2.http.GET

interface HomeService {
    @GET("/mainview/watching")
    fun getWatchingList(){

    }
    @GET("mainview/recommend")
    fun getRecommendList(){

    }
}