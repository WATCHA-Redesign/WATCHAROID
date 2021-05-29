package com.yjooooo.watcharoid.network.api

import com.yjooooo.watcharoid.ui.home.model.ResponseBannerList
import com.yjooooo.watcharoid.ui.home.model.ResponseWatchingList
import retrofit2.http.GET

interface HomeYjooService {
    @GET("/mainview/banner")
    suspend fun getMainBanner(): ResponseBannerList
    @GET("/mainview/watching")
    suspend fun getWatchingList(): ResponseWatchingList
}