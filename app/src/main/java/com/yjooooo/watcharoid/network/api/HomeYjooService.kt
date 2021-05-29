package com.yjooooo.watcharoid.network.api

import retrofit2.http.GET

interface HomeYjooService {
    @GET("/mainview/banner")
    fun getMainBanner(){

    }
    @GET("/mainview/watching")
    fun getWatchingList(){

    }
}