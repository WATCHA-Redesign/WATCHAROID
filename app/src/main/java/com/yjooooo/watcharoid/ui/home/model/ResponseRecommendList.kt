package com.yjooooo.watcharoid.ui.home.model

import com.google.gson.annotations.SerializedName

data class ResponseRecommendList(
    @SerializedName("data")
    val `data`: RecommendListData,
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Boolean
)
data class RecommendListData (
    @SerializedName("mainRecommend")
    val mainRecommend: List<MainRecommend>
)

data class MainRecommend(
    @SerializedName("image")
    val image: String,
    @SerializedName("title")
    val title: String
)