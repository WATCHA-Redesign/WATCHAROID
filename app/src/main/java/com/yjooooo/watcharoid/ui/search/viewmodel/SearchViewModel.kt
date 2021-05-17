package com.yjooooo.watcharoid.ui.search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yjooooo.watcharoid.R
import com.yjooooo.watcharoid.ui.search.model.HighScoreData

class SearchViewModel: ViewModel() {
    private val _highScoreList = MutableLiveData<List<HighScoreData>>()
    val highScoreList: LiveData<List<HighScoreData>>
        get() = _highScoreList

    fun setHighScoreList() {
        _highScoreList.value = mutableListOf(
            HighScoreData(R.drawable.img_rv_high_score),
            HighScoreData(R.drawable.img_rv_high_score),
            HighScoreData(R.drawable.img_rv_high_score)
        )
    }
}