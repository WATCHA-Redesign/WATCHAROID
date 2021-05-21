package com.yjooooo.watcharoid.ui.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.yjooooo.watcharoid.R
import com.yjooooo.watcharoid.databinding.ItemTopSearchBinding
import com.yjooooo.watcharoid.ui.search.model.TopSearchData

class TopSearchRcvAdapter : RecyclerView.Adapter<TopSearchRcvAdapter.TopSearchViewHolder>() {
    private var topSearchList = emptyList<TopSearchData>()

    class TopSearchViewHolder(private val binding: ItemTopSearchBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(topSearchData: TopSearchData) {
            binding.topSearchData = topSearchData
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopSearchViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemTopSearchBinding =
            DataBindingUtil.inflate(
                layoutInflater,
                R.layout.item_top_search,
                parent,
                false
            )
        return TopSearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopSearchViewHolder, position: Int) {
        holder.bind(topSearchList[position])
    }

    override fun getItemCount(): Int = topSearchList.size

    fun setTopSearchList(topSearchList: List<TopSearchData>) {
        this.topSearchList = topSearchList
        notifyDataSetChanged()
    }
}