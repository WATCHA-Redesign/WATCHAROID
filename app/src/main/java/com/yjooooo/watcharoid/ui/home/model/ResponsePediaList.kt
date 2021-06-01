package com.yjooooo.watcharoid.ui.home.model

import com.google.gson.annotations.SerializedName

data class ResponsePediaList(
    @SerializedName("data")
    val `data`: PediaListData,
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Boolean
)

data class PediaListData(
    @SerializedName("mainPedia")
    val mainPedia: List<MainPedia>
)

data class MainPedia(
    @SerializedName("image")
    val image: String,
    @SerializedName("nickname")
    val nickname: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("titleDetail")
    val titleDetail: String,
    @SerializedName("watchingNum")
    val watchingNum: Int
)