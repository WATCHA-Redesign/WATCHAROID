package com.yjooooo.watcharoid.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yjooooo.watcharoid.R
import com.yjooooo.watcharoid.ui.home.model.BannerData

class HomeViewModel : ViewModel() {
    private val _bannerData = MutableLiveData<List<BannerData>>()
    val bannerList: LiveData<List<BannerData>>
        get() = _bannerData

    fun setBannerData() {
        _bannerData.value = mutableListOf(
            BannerData(R.drawable.img_vp_home_1),
            BannerData(R.drawable.img_vp_home_2),
            BannerData(R.drawable.img_vp_home_3),
            BannerData(R.drawable.img_vp_home_4),
            BannerData(R.drawable.img_vp_home_5),
            BannerData(R.drawable.img_vp_home_6),
            BannerData(R.drawable.img_vp_home_7)
        )
    }
}