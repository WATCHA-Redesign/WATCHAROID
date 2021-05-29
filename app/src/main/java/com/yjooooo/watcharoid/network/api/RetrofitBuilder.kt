package com.yjooooo.watcharoid.network.api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val BASE_URL = "http://15.164.171.220:5000/api/"

    private val watchaRetrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val homeService: HomeService = watchaRetrofit.create(HomeService::class.java)
    val searchService: SearchService = watchaRetrofit.create(SearchService::class.java)
    val homeYjooService: HomeYjooService = watchaRetrofit.create(HomeYjooService::class.java)
    val searchYjooService: SearchYjooService = watchaRetrofit.create(SearchYjooService::class.java)
}
