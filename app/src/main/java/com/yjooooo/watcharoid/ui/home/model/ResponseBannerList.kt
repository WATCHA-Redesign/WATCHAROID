package com.yjooooo.watcharoid.ui.home.model


import com.google.gson.annotations.SerializedName

data class ResponseBannerList(
    @SerializedName("data")
    val `data`: BannerListData,
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Boolean
)

data class BannerListData(
    @SerializedName("mainBanner")
    val mainBanner: List<MainBanner>
)

data class MainBanner(
    @SerializedName("description")
    val description: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("largeTitle")
    val largeTitle: String
)
