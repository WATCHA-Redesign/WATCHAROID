package com.yjooooo.watcharoid.ui.search.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import com.yjooooo.watcharoid.R
import com.yjooooo.watcharoid.databinding.FragmentSearchBinding
import com.yjooooo.watcharoid.ui.base.BaseFragment
import com.yjooooo.watcharoid.ui.search.adapter.HighScoreRcvAdapter
import com.yjooooo.watcharoid.ui.search.adapter.PopularSearchRcvAdapter
import com.yjooooo.watcharoid.ui.search.viewmodel.SearchViewModel


class SearchFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {
    private val searchViewModel: SearchViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding.lifecycleOwner = this
        searchViewModel.setHighScoreList()
        setHighScoreRcvAdapter()
        setHighScoreListObserve()

        searchViewModel.getPopularSearchContentList()
        setTopSearchRcvAdapter()
        setTopSearchContentListObserve()

        return binding.root
    }

    private fun setHighScoreRcvAdapter() {
        binding.rvSearchHighScore.adapter = HighScoreRcvAdapter()
    }

    private fun setHighScoreListObserve() {
        searchViewModel.highScoreList.observe(viewLifecycleOwner) { highScoreList ->
            with(binding.rvSearchHighScore.adapter as HighScoreRcvAdapter) {
                setHighScoreList(highScoreList)
            }
        }
    }

    private fun setTopSearchRcvAdapter() {
        binding.rvSearchTop.adapter =
            PopularSearchRcvAdapter()
    }

    private fun setTopSearchContentListObserve() {
        searchViewModel.popularSearchList.observe(viewLifecycleOwner) { topSearchList ->
            with(binding.rvSearchTop.adapter as PopularSearchRcvAdapter) {
                setTopSearchList(topSearchList)
            }
        }
    }
}