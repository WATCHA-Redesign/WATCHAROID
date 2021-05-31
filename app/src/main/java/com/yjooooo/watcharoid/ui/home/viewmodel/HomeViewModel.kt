package com.yjooooo.watcharoid.ui.home.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.yjooooo.watcharoid.R
import com.yjooooo.watcharoid.network.api.HomeService
import com.yjooooo.watcharoid.network.api.RetrofitBuilder
import com.yjooooo.watcharoid.ui.home.model.*

class HomeViewModel : ViewModel() {
    private val _bannerList = MutableLiveData<List<BannerData>>()
    val bannerList: LiveData<List<BannerData>>
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


    fun setBannerList() {
        _bannerList.value = mutableListOf(
            BannerData(R.drawable.img_vp_home_1),
            BannerData(R.drawable.img_vp_home_2),
            BannerData(R.drawable.img_vp_home_3),
            BannerData(R.drawable.img_vp_home_4),
            BannerData(R.drawable.img_vp_home_5),
            BannerData(R.drawable.img_vp_home_6),
            BannerData(R.drawable.img_vp_home_7)
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

    fun getPediaList() {
        val call = RetrofitBuilder.homeService.getWatchaPedia()
        call.enqueue(object : Callback<ResponsePediaList> {
            override fun onResponse(
                call: Call<ResponsePediaList>, response: Response<ResponsePediaList>
            ) {
               if(response.isSuccessful){

                   val list = mutableListOf<PediaData>()
                   val data = response.body()?.data
                   val pedia = data?.mainPedia

                   if (pedia != null) {
                       for(i in pedia.indices){
                           list.add(PediaData(
                               pedia[i].image,
                               pedia[i].title,
                               pedia[i].titleDetail,
                               pedia[i].watchingNum,
                               pedia[i].nickname
                           ))
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
                if(response.isSuccessful){
                    val list = mutableListOf<TodayData>()
                    val data = response.body()?.data
                    val recommend = data?.mainRecommend

                    if(recommend != null){
                        for(i in recommend.indices){
                            list.add(TodayData(
                                recommend[i].image,
                                recommend[i].title
                            ))
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

