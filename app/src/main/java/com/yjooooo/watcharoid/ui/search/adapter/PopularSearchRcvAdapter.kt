package com.yjooooo.watcharoid.ui.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.yjooooo.watcharoid.R
import com.yjooooo.watcharoid.databinding.ItemPopularSearchBinding
import com.yjooooo.watcharoid.ui.search.model.PopularSearchData

class PopularSearchRcvAdapter : RecyclerView.Adapter<PopularSearchRcvAdapter.PopularSearchViewHolder>() {
    private var popularSearchList = emptyList<PopularSearchData>()

    class PopularSearchViewHolder(private val binding: ItemPopularSearchBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(popularSearchData: PopularSearchData) {
            binding.popularSearchData = popularSearchData
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularSearchViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemPopularSearchBinding =
            DataBindingUtil.inflate(
                layoutInflater,
                R.layout.item_popular_search,
                parent,
                false
            )
        return PopularSearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularSearchViewHolder, position: Int) {
        holder.bind(popularSearchList[position])
    }

    override fun getItemCount(): Int = popularSearchList.size

    fun setTopSearchList(popularSearchList: List<PopularSearchData>) {
        this.popularSearchList = popularSearchList
        notifyDataSetChanged()
    }
}