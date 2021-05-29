package com.yjooooo.watcharoid.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.yjooooo.watcharoid.R
import com.yjooooo.watcharoid.databinding.ItemBannerBinding
import com.yjooooo.watcharoid.ui.home.model.MainBanner

class BannerViewPagerAdapter : RecyclerView.Adapter<BannerViewPagerAdapter.BannerViewHolder>() {
    private var bannerList = emptyList<MainBanner>()
    class BannerViewHolder(private val binding: ItemBannerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(bannerData: MainBanner) {
            binding.bannerData = bannerData
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemBannerBinding =
            DataBindingUtil.inflate(
                layoutInflater,
                R.layout.item_banner,
                parent,
                false
            )
        return BannerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bind(bannerList[position])
    }

    override fun getItemCount(): Int = bannerList.size

    fun setBanners(bannerList: List<MainBanner>) {
        this.bannerList = bannerList
        notifyDataSetChanged()
    }
}