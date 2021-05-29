package com.yjooooo.watcharoid.ui.home.model


import com.google.gson.annotations.SerializedName

data class ResponseWatchingList(
    @SerializedName("data")
    val `data`: WatchingListData,
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Boolean
)

data class WatchingListData(
    @SerializedName("mainWatching")
    val mainWatching: List<MainWatching>
)

data class MainWatching(
    @SerializedName("image")
    val image: String,
    @SerializedName("progress")
    val progress: Int,
    @SerializedName("title")
    val title: String
)