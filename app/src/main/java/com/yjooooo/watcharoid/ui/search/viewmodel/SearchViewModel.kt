package com.yjooooo.watcharoid.ui.search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yjooooo.watcharoid.R
import com.yjooooo.watcharoid.ui.search.model.HighScoreData
import com.yjooooo.watcharoid.ui.search.model.TopSearchData

class SearchViewModel: ViewModel() {
    private val _highScoreList = MutableLiveData<List<HighScoreData>>()
    val highScoreList: LiveData<List<HighScoreData>>
        get() = _highScoreList

    private val _topSearchContentList = MutableLiveData<List<TopSearchData>>()
    val topSearchContentList: LiveData<List<TopSearchData>>
        get() = _topSearchContentList


    fun setHighScoreList() {
        _highScoreList.value = mutableListOf(
            HighScoreData(R.drawable.img_rv_high_score_1),
            HighScoreData(R.drawable.img_rv_high_score_2)
        )
    }

    fun setTopSearchContentList() {
        _topSearchContentList.value = mutableListOf(
            TopSearchData(R.drawable.card_search_small_android1),
            TopSearchData(R.drawable.card_search_small_android2),
            TopSearchData(R.drawable.card_search_small_android3),
            TopSearchData(R.drawable.card_search_small_android4),
            TopSearchData(R.drawable.card_search_small_android5)
        )
    }
}