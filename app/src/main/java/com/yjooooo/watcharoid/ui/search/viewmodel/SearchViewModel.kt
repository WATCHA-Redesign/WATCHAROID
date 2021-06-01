package com.yjooooo.watcharoid.ui.search.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yjooooo.watcharoid.R
import com.yjooooo.watcharoid.network.api.RetrofitBuilder
import com.yjooooo.watcharoid.ui.search.model.HighScore
import com.yjooooo.watcharoid.ui.search.model.TopSearchData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import com.yjooooo.watcharoid.ui.home.model.ResponsePediaList
import com.yjooooo.watcharoid.ui.search.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel : ViewModel() {
    private val _highScoreList = MutableLiveData<List<HighScoreData>>()
    val highScoreList: LiveData<List<HighScoreData>>
        get() = _highScoreList

    private val _popularSearchList = MutableLiveData<List<PopularSearchData>>()
    val popularSearchList: LiveData<List<PopularSearchData>>
        get() = _popularSearchList

    private val _movieMateList = MutableLiveData<List<MovieMateData>>()
    val movieMateList: LiveData<List<MovieMateData>>
        get() = _movieMateList

    fun setTopSearchContentList() {
        _topSearchContentList.value = mutableListOf(
            TopSearchData(R.drawable.card_search_small_android1),
            TopSearchData(R.drawable.card_search_small_android2),
            TopSearchData(R.drawable.card_search_small_android3),
            TopSearchData(R.drawable.card_search_small_android4),
            TopSearchData(R.drawable.card_search_small_android5)
        )

    fun getPopularSearchContentList() {
        val call = RetrofitBuilder.searchService.getPopularSearch()
        call.enqueue(object : Callback<ResponsePopularSearchList> {
            override fun onResponse(
                call: Call<ResponsePopularSearchList>, response: Response<ResponsePopularSearchList>
            ) {
                if (response.isSuccessful) {

                    val list = mutableListOf<PopularSearchData>()
                    val data = response.body()?.data
                    val popular = data?.searchPopular

                    if (popular != null) {
                        for (i in popular.indices) {
                            list.add(
                                PopularSearchData(
                                    popular[i].image,
                                    popular[i].name
                                )
                            )
                        }
                    }
                    _popularSearchList.value = list
                }
            }

            override fun onFailure(call: Call<ResponsePopularSearchList>, t: Throwable) {
                Log.d("NetworkTest", "error:$t")
            }
        })
    }

    fun getMovieMateContentList() {
        val call = RetrofitBuilder.searchService.getMovieMate()
        call.enqueue(object : Callback<ResponseMovieMateList> {
            override fun onResponse(
                call: Call<ResponseMovieMateList>, response: Response<ResponseMovieMateList>
            ) {
                if (response.isSuccessful) {

                    val list = mutableListOf<MovieMateData>()
                    val data = response.body()?.data
                    val mate = data?.searchMate

                    if (mate != null) {
                        for (i in mate.indices) {
                            list.add(
                                MovieMateData(
                                    mate[i].name,
                                    mate[i].role
                                )
                            )
                        }
                    }
                    _movieMateList.value = list
                }
            }

            override fun onFailure(call: Call<ResponseMovieMateList>, t: Throwable) {
                Log.d("NetworkTest", "error:$t")
            }
        })
    }

    fun requestHighScoreList() = viewModelScope.launch(Dispatchers.IO) {
        try {
            _highScoreList.postValue(RetrofitBuilder.searchYjooService.getHighScore().data.highScoreList)
            Log.d("tag_server",highScoreList.value.toString())
        } catch (e: HttpException) {

        }
    }
}