package com.yjooooo.watcharoid.ui.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.yjooooo.watcharoid.ui.home.view.HomeFragment
import com.yjooooo.watcharoid.ui.search.view.SearchFragment

class MainViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> HomeFragment()
        1 -> HomeFragment()
        2 -> SearchFragment()
        3 -> SearchFragment()
        else -> throw IllegalStateException("Unexpected position $position")
    }

    override fun getItemCount(): Int = 4
}