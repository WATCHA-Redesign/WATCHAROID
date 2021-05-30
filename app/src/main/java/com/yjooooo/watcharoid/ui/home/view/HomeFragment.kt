package com.yjooooo.watcharoid.ui.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import com.google.android.material.tabs.TabLayoutMediator
import com.yjooooo.watcharoid.R
import com.yjooooo.watcharoid.databinding.FragmentHomeBinding
import com.yjooooo.watcharoid.ui.base.BaseFragment
import com.yjooooo.watcharoid.ui.home.adapter.BannerViewPagerAdapter
import com.yjooooo.watcharoid.ui.home.adapter.ContinueListAdapter
import com.yjooooo.watcharoid.ui.home.adapter.PediaListAdapter
import com.yjooooo.watcharoid.ui.home.adapter.TodayListAdapter
import com.yjooooo.watcharoid.ui.home.viewmodel.HomeViewModel


class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val homeViewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding.lifecycleOwner = this
        homeViewModel.requestBannerList()
        fadeInAtScrolling()
        setBannerViewPagerAdapter()
        setBannerListObserve()
        setIndicator()

        homeViewModel.setPediaList()
        setPediaAdapter()
        setPediaListObserve()

        homeViewModel.setTodayList()
        setTodayAdapter()
        setTodayListObserve()

        homeViewModel.requestWatchingList()
        setContinueAdapter()
        setContinueListObserve()

        return binding.root
    }

    private fun setBannerViewPagerAdapter() {
        binding.vpHomeBanner.adapter = BannerViewPagerAdapter()
    }

    private fun setIndicator() {
        TabLayoutMediator(binding.tabHome, binding.vpHomeBanner) { tab, position -> }.attach()
    }

    private fun setBannerListObserve() {
        homeViewModel.bannerList.observe(viewLifecycleOwner) { bannerList ->
            with(binding.vpHomeBanner.adapter as BannerViewPagerAdapter) {
                setBanners(bannerList)
            }
        }
    }


    private fun fadeInAtScrolling() {
        binding.constraintHomeTop.alpha = 0f
        binding.scrollviewHome.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (scrollY in 700..900 && binding.constraintHomeTop.alpha < 1f) {
                binding.constraintHomeTop.alpha += 0.04f
            } else if (scrollY <= 700 && binding.constraintHomeTop.alpha > 0f) {
                binding.constraintHomeTop.alpha -= 0.04f
            }
            if (scrollY < 200) {
                binding.constraintHomeTop.alpha = 0f
            } else if (scrollY > 900) {
                binding.constraintHomeTop.alpha = 1f
            }
        }
    }

    private fun setPediaAdapter(){
        binding.rvHomePedia.adapter = PediaListAdapter()
    }
    
    private fun setPediaListObserve() {
        homeViewModel.pediaList.observe(viewLifecycleOwner) {
            pediaList -> with(binding.rvHomePedia.adapter as PediaListAdapter){
                setPedia(pediaList)
            }
        }
    }

    private fun setTodayAdapter(){
        binding.rvHomeToday.adapter = TodayListAdapter()
    }

    private fun setTodayListObserve() {
        homeViewModel.todayList.observe(viewLifecycleOwner) {
                todayList -> with(binding.rvHomeToday.adapter as TodayListAdapter){
                    setToday(todayList)
                }
        }
    }

    private fun setContinueAdapter(){
        binding.rvHomeContinue.adapter = ContinueListAdapter()
    }

    private fun setContinueListObserve() {
        homeViewModel.continueList.observe(viewLifecycleOwner) {
                continueList -> with(binding.rvHomeContinue.adapter as ContinueListAdapter){
                    setContinue(continueList)
                }
        }
    }
}