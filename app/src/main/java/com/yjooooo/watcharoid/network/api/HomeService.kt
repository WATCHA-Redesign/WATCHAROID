package com.yjooooo.watcharoid.network.api

import retrofit2.http.GET

interface HomeService {
    @GET("mainview/pedia")
    fun getWatchaPedia()
    @GET("mainview/recommend")
    fun getRecommendList()
}