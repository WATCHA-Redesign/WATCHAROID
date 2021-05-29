package com.yjooooo.watcharoid.ui.home.model


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
    @SerializedName("mainPedia")
    val mainPedia: List<MainPedia>
)

data class MainPedia(
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String
)