package com.yjooooo.watcharoid.network.api

import com.yjooooo.watcharoid.ui.search.model.ResponseHighScoreList
import retrofit2.http.GET

interface SearchYjooService {
    @GET("searchpage/high")
    fun getHighScore(): ResponseHighScoreList
}