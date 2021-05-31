package com.yjooooo.watcharoid.network.api

import com.yjooooo.watcharoid.ui.home.model.ResponsePediaList
import com.yjooooo.watcharoid.ui.home.model.ResponseRecommendList
import retrofit2.Call
import retrofit2.http.GET

interface HomeService {
    @GET("mainpage/pedia")
    fun getWatchaPedia() : Call<ResponsePediaList>

    @GET("mainpage/recommend")
    fun getRecommendList() : Call<ResponseRecommendList>
}