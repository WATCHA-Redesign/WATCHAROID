package com.yjooooo.watcharoid.ui.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.yjooooo.watcharoid.R
import com.yjooooo.watcharoid.databinding.FragmentHomeBinding
import com.yjooooo.watcharoid.ui.base.BaseFragment
import com.yjooooo.watcharoid.ui.home.HomeViewModel
import com.yjooooo.watcharoid.ui.home.adapter.BannerViewPagerAdapter


class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val homeViewModel: HomeViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding.lifecycleOwner = this
        homeViewModel.setBannerData()
        setBannerViewPagerAdapter()
        setBannerListObserve()
        return binding.root
    }

    private fun setBannerViewPagerAdapter() {
        binding.vpHomeBanner.adapter = BannerViewPagerAdapter()
    }

    private fun setBannerListObserve() {
        homeViewModel.bannerList.observe(viewLifecycleOwner) { bannerList ->
            with(binding.vpHomeBanner.adapter as BannerViewPagerAdapter) {
                setBanners(bannerList)
            }
        }
    }

}