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

class SearchViewModel: ViewModel() {
    private val _highScoreList = MutableLiveData<List<HighScore>>()
    val highScoreList: LiveData<List<HighScore>>
        get() = _highScoreList

    private val _topSearchContentList = MutableLiveData<List<TopSearchData>>()
    val topSearchContentList: LiveData<List<TopSearchData>>
        get() = _topSearchContentList

    fun setTopSearchContentList() {
        _topSearchContentList.value = mutableListOf(
            TopSearchData(R.drawable.card_search_small_android1),
            TopSearchData(R.drawable.card_search_small_android2),
            TopSearchData(R.drawable.card_search_small_android3),
            TopSearchData(R.drawable.card_search_small_android4),
            TopSearchData(R.drawable.card_search_small_android5)
        )
    }

    fun requestHighScoreList() = viewModelScope.launch(Dispatchers.IO) {
        try {
            _highScoreList.postValue(RetrofitBuilder.searchYjooService.getHighScore().data.highScoreList)
            Log.d("tag_server",highScoreList.value.toString())
        } catch (e: HttpException) {

        }
    }
}