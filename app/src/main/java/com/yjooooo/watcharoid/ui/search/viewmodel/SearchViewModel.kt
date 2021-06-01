package com.yjooooo.watcharoid.ui.search.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yjooooo.watcharoid.network.api.RetrofitBuilder
import com.yjooooo.watcharoid.ui.search.model.HighScore
import com.yjooooo.watcharoid.ui.search.model.PopularSearchData
import com.yjooooo.watcharoid.ui.search.model.ResponsePopularSearchList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

class SearchViewModel : ViewModel() {
    private val _highScoreList = MutableLiveData<List<HighScore>>()
    val highScoreList: LiveData<List<HighScore>>
        get() = _highScoreList

    private val _popularSearchList = MutableLiveData<List<PopularSearchData>>()
    val popularSearchList: LiveData<List<PopularSearchData>>
        get() = _popularSearchList

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

    fun requestHighScoreList() = viewModelScope.launch(Dispatchers.IO) {
        try {
            _highScoreList.postValue(RetrofitBuilder.searchYjooService.getHighScore().data.highScoreList)
            Log.d("tag_server", highScoreList.value.toString())
        } catch (e: HttpException) {

        }
    }
}