package com.yjooooo.watcharoid.network.api

import com.yjooooo.watcharoid.ui.search.model.ResponsePopularSearchList
import retrofit2.Call
import retrofit2.http.GET

interface SearchService {
    @GET("searchpage/popular")
    fun getPopularSearch() : Call<ResponsePopularSearchList>
    @GET("searchpage/collection")
    fun getWatchaCollection()
}