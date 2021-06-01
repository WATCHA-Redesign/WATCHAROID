package com.yjooooo.watcharoid.ui.search.model

import com.google.gson.annotations.SerializedName

data class ResponsePopularSearchList(
    @SerializedName("data")
    val `data`: PopularSearchListData,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("message")
    val message: String
)
data class PopularSearchListData (
    @SerializedName("searchPopular")
    val searchPopular: List<SearchPopular>
)

data class SearchPopular(
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String
)