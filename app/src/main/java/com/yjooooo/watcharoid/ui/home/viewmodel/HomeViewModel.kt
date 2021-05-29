package com.yjooooo.watcharoid.ui.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yjooooo.watcharoid.R
import com.yjooooo.watcharoid.network.api.RetrofitBuilder
import com.yjooooo.watcharoid.ui.home.model.ContinueData
import com.yjooooo.watcharoid.ui.home.model.MainBanner
import com.yjooooo.watcharoid.ui.home.model.PediaData
import com.yjooooo.watcharoid.ui.home.model.TodayData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

class HomeViewModel : ViewModel() {
    private val _bannerList = MutableLiveData<List<MainBanner>>()
    val bannerList: LiveData<List<MainBanner>>
        get() = _bannerList

    private val _pediaList = MutableLiveData<List<PediaData>>()
    val pediaList: LiveData<List<PediaData>>
        get() = _pediaList

    private val _todayList = MutableLiveData<List<TodayData>>()
    val todayList: LiveData<List<TodayData>>
        get() = _todayList

    private val _continueList = MutableLiveData<List<ContinueData>>()
    val continueList: LiveData<List<ContinueData>>
        get() = _continueList

    fun setPediaList() {
        _pediaList.value = mutableListOf(
            PediaData(
                R.drawable.card_main_highkick,
                23,
                "거침없이 무야호",
                "거침없이 하이킥: 에피소드 157",
                "봉준호사랑해"
            ),
            PediaData(
                R.drawable.card_main_big_img_party,
                14,
                "대만영화",
                "상견니",
                "현경"
            )
        )
    }

    fun setContinueList() {
        _continueList.value = mutableListOf(
            ContinueData(
                R.drawable.card_small,
                "캐롤"
            ),
            ContinueData(
                R.drawable.card_small_2,
                "검정 고무신"
            ),
            ContinueData(
                R.drawable.card_small_3,
                "시카고"
            )
        )
    }

    fun setTodayList() {
        _todayList.value = mutableListOf(
            TodayData(
                R.drawable.card_small_img_android_4,
                "싱스트리트"
            ),
            TodayData(
                R.drawable.card_small_img_android_5,
                "드림걸즈"
            ),
            TodayData(
                R.drawable.card_small_img_android_6,
                "하하하 냥이네"
            )
        )
    }

    fun requestBannerList() = viewModelScope.launch(Dispatchers.IO) {
        try {
            Log.d("server_tag","success")
            //val responseBannerList = RetrofitBuilder.homeYjooService.getMainBanner()
            //Log.d("server_tag",responseBannerList.data.mainBanner.toString())
            _bannerList.postValue(RetrofitBuilder.homeYjooService.getMainBanner().data.mainBanner)
            Log.d("server_tag",bannerList.value.toString())
            Log.d("server_tag","success2")
        } catch (e: HttpException) {

        }
    }

}