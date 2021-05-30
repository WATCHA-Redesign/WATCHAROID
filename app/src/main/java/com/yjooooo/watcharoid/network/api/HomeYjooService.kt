package com.yjooooo.watcharoid.network.api

import com.yjooooo.watcharoid.ui.home.model.ResponseBannerList
import com.yjooooo.watcharoid.ui.home.model.ResponseWatchingList
import retrofit2.http.GET

interface HomeYjooService {
    @GET("mainpage/banner")
    suspend fun getMainBanner(): ResponseBannerList

    @GET("mainpage/watching")
    suspend fun getWatchingList(): ResponseWatchingList
}