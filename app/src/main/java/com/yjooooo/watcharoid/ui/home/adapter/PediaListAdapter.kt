package com.yjooooo.watcharoid.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yjooooo.watcharoid.databinding.ItemHomePediaBinding
import com.yjooooo.watcharoid.ui.home.model.PediaData

class PediaListAdapter: RecyclerView.Adapter<PediaListAdapter.PediaViewHolder>(){

    private var pediaList = emptyList<PediaData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PediaViewHolder {
        val binding = ItemHomePediaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PediaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PediaViewHolder, position: Int) {
        holder.bind(pediaList[position])
    }

    override fun getItemCount(): Int = pediaList.size


    fun setPedia(pediaList: List<PediaData>) {
        this.pediaList = pediaList
        notifyDataSetChanged()
    }

    class PediaViewHolder(
        private val binding : ItemHomePediaBinding
    ):RecyclerView.ViewHolder(binding.root){
        fun bind(pediaData: PediaData){ binding.pediaData = pediaData}
    }
}
