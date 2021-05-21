package com.yjooooo.watcharoid.ui.main.view

import android.os.Build
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.yjooooo.watcharoid.R
import com.yjooooo.watcharoid.databinding.ActivityMainBinding
import com.yjooooo.watcharoid.ui.base.BaseActivity
import com.yjooooo.watcharoid.ui.main.adapter.MainViewPagerAdapter

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //StatusBarUtil.setStatusBar(this, resources.getColor(R.color.white, null))
        window.apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                setDecorFitsSystemWindows(false)
            }
        }
        setMainViewpagerAdapter()
        setOnBottomNavigationClick()
    }

    private fun setMainViewpagerAdapter() {
        binding.vpMain.apply {
            adapter = MainViewPagerAdapter(this@MainActivity)
            isUserInputEnabled = false
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.bottomNaviMain.selectedItemId =
                        when (position) {
                            0 -> R.id.menu_bottom_navi_home
                            1 -> R.id.menu_bottom_navi_category
                            2 -> R.id.menu_bottom_navi_search
                            3 -> R.id.menu_bottom_navi_mypage
                            else -> throw IndexOutOfBoundsException()
                        }
                }
            })
        }
    }

    private fun setOnBottomNavigationClick() {
        binding.bottomNaviMain.setOnNavigationItemSelectedListener {
            binding.vpMain.currentItem = when (it.itemId) {
                R.id.menu_bottom_navi_home -> 0
                R.id.menu_bottom_navi_category -> 1
                R.id.menu_bottom_navi_search -> 2
                R.id.menu_bottom_navi_mypage -> 3
                else -> throw IndexOutOfBoundsException()
            }
            true
        }
    }
}

