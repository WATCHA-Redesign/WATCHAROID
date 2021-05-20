package com.yjooooo.watcharoid.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yjooooo.watcharoid.R
import com.yjooooo.watcharoid.ui.home.model.BannerData
import com.yjooooo.watcharoid.ui.home.model.ContinueData
import com.yjooooo.watcharoid.ui.home.model.TodayData
import com.yjooooo.watcharoid.ui.home.model.PediaData

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

    fun setPediaList() {
        _pediaList.value = mutableListOf(
            PediaData(
                R.drawable.card_main_highkick,
                "+23",
                "거침없이 무야호",
                "거침없이 하이킥: 에피소드 157",
                "봉준호사랑해님 외 27명 시청 중"
            ),
            PediaData(
                R.drawable.card_main_big_img_android,
                "+14",
                "대만영화",
                "상견니",
                "현경님 외 14명 시청 중"
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

    fun setTodayList(){
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
}