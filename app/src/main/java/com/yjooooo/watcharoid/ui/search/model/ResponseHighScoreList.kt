package com.yjooooo.watcharoid.ui.search.model


import com.google.gson.annotations.SerializedName

data class ResponseHighScoreList(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Boolean
)

data class Data(
    @SerializedName("searchHigh")
    val highScoreList: List<HighScore>
)

data class HighScore(
    @SerializedName("image")
    val image: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("subtitle")
    val subtitle: String
)