package com.yjooooo.watcharoid.ui.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.yjooooo.watcharoid.R
import com.yjooooo.watcharoid.databinding.ItemHighScoreBinding
import com.yjooooo.watcharoid.ui.search.model.HighScoreData

class HighScoreRcvAdapter : RecyclerView.Adapter<HighScoreRcvAdapter.HighScoreViewHolder>() {
    private var highScoreList = emptyList<HighScoreData>()

    class HighScoreViewHolder(private val binding: ItemHighScoreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(highScoreData: HighScoreData) {
            binding.highScoreData = highScoreData
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HighScoreViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemHighScoreBinding =
            DataBindingUtil.inflate(
                layoutInflater,
                R.layout.item_high_score,
                parent,
                false
            )
        return HighScoreViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HighScoreViewHolder, position: Int) {
        holder.bind(highScoreList[position])
    }

    override fun getItemCount(): Int = highScoreList.size

    fun setHighScoreList(highScoreList: List<HighScoreData>) {
        this.highScoreList = highScoreList
        notifyDataSetChanged()
    }
}