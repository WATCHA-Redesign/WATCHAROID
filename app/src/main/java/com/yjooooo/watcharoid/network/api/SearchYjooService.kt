package com.yjooooo.watcharoid.network.api

import retrofit2.http.GET

interface SearchYjooService {
    @GET("/searchpage/high")
    fun getHighScore(){

    }
}