package com.yjooooo.watcharoid.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yjooooo.watcharoid.databinding.ItemHomeContinueBinding
import com.yjooooo.watcharoid.ui.home.model.MainWatching

class ContinueListAdapter: RecyclerView.Adapter<ContinueListAdapter.ContinueViewHolder>() {

    private var continueList = emptyList<MainWatching>()

    class ContinueViewHolder (
        private val binding : ItemHomeContinueBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(continueData: MainWatching){
            binding.continueData = continueData
            binding.seekBarContinue.progress = continueData.progress.toFloat()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContinueViewHolder {
        val binding = ItemHomeContinueBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ContinueViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContinueViewHolder, position: Int) {
        holder.bind(continueList[position])
    }

    override fun getItemCount(): Int = continueList.size

    fun setContinue(continueList: List<MainWatching>){
        this.continueList = continueList
        notifyDataSetChanged()
    }
}