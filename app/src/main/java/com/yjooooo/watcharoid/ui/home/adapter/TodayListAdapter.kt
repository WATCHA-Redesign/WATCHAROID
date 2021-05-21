package com.yjooooo.watcharoid.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yjooooo.watcharoid.databinding.ItemHomeTodayBinding
import com.yjooooo.watcharoid.ui.home.model.TodayData

class TodayListAdapter: RecyclerView.Adapter<TodayListAdapter.TodayViewHolder>(){

    private var todayList = emptyList<TodayData>()

    class TodayViewHolder(
        private val binding : ItemHomeTodayBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(todayData: TodayData){binding.todayData = todayData}
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TodayListAdapter.TodayViewHolder {
        val binding = ItemHomeTodayBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TodayViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodayListAdapter.TodayViewHolder, position: Int) {
        holder.bind(todayList[position])
    }

    override fun getItemCount(): Int {
        return todayList.size
    }

    fun setToday(todayList : List<TodayData>){
        this.todayList = todayList
        notifyDataSetChanged()
    }

}
