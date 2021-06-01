package com.yjooooo.watcharoid.ui.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yjooooo.watcharoid.network.api.RetrofitBuilder
import com.yjooooo.watcharoid.ui.home.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

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

    private val _continueList = MutableLiveData<List<MainWatching>>()
    val continueList: LiveData<List<MainWatching>>
        get() = _continueList

    fun requestBannerList() = viewModelScope.launch(Dispatchers.IO) {
        try {
            _bannerList.postValue(RetrofitBuilder.homeYjooService.getMainBanner().data.mainBanner)
        } catch (e: HttpException) {

        }
    }

    fun requestWatchingList() = viewModelScope.launch(Dispatchers.IO) {
        try {
            _continueList.postValue(RetrofitBuilder.homeYjooService.getWatchingList().data.mainWatching)
        } catch (e: HttpException) {

        }
    }
    fun getPediaList() {
        val call = RetrofitBuilder.homeService.getWatchaPedia()
        call.enqueue(object : Callback<ResponsePediaList> {
            override fun onResponse(
                call: Call<ResponsePediaList>, response: Response<ResponsePediaList>
            ) {
                if (response.isSuccessful) {

                    val list = mutableListOf<PediaData>()
                    val data = response.body()?.data
                    val pedia = data?.mainPedia

                    if (pedia != null) {
                        for (i in pedia.indices) {
                            list.add(
                                PediaData(
                                    pedia[i].image,
                                    pedia[i].title,
                                    pedia[i].titleDetail,
                                    pedia[i].watchingNum,
                                    pedia[i].nickname
                                )
                            )
                        }
                    }
                    _pediaList.value = list
                }
            }

            override fun onFailure(call: Call<ResponsePediaList>, t: Throwable) {
                Log.d("NetworkTest", "error:$t")
            }
        })
    }

    fun getTodayList() {
        val call = RetrofitBuilder.homeService.getRecommendList()
        call.enqueue(object : Callback<ResponseRecommendList> {
            override fun onResponse(
                call: Call<ResponseRecommendList>, response: Response<ResponseRecommendList>
            ) {
                if (response.isSuccessful) {
                    val list = mutableListOf<TodayData>()
                    val data = response.body()?.data
                    val recommend = data?.mainRecommend

                    if (recommend != null) {
                        for (i in recommend.indices) {
                            list.add(
                                TodayData(
                                    recommend[i].image,
                                    recommend[i].title
                                )
                            )
                        }

                        _todayList.value = list
                    }

                }
            }

            override fun onFailure(call: Call<ResponseRecommendList>, t: Throwable) {
                Log.d("NetworkTest", "error:$t")
            }
        })
    }
}

