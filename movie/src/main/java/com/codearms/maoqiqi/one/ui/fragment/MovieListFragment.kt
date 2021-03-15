package com.codearms.maoqiqi.one.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codearms.maoqiqi.log.LogUtils
import com.codearms.maoqiqi.one.DataBindingViewHolder
import com.codearms.maoqiqi.one.ListFragment
import com.codearms.maoqiqi.one.decoration.RecyclerViewItemDecoration
import com.codearms.maoqiqi.one.movie.R
import com.codearms.maoqiqi.one.movie.databinding.ItemMovieListBinding

/**
 * 电影列表
 * link: https://github.com/maoqiqi/one
 * e-mail: fengqi.mao.march@gmail.com
 * author: March
 * date: 2021-03-04 21:01
 * version v1.0.0
 */
class MovieListFragment : ListFragment() {

    private val movieAdapter: MovieAdapter by lazy { MovieAdapter(arrayListOf()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val position = arguments?.getInt("position", 0)
        binding.refreshLayout.apply {
            setEnableRefresh(false)
            setEnableLoadMore(false)
        }
        binding.recyclerView.apply {
//            layoutManager = LinearLayoutManager(requireContext())/*.apply { orientation=LinearLayoutManager.HORIZONTAL }*/
            layoutManager = GridLayoutManager(requireContext(), 3).apply { orientation = LinearLayoutManager.HORIZONTAL }
//            isNestedScrollingEnabled = false
//            setHasFixedSize(true)
            adapter = movieAdapter
            addItemDecoration(RecyclerViewItemDecoration(10, 20, 30, 40, 100))
        }
    }

    override fun loadData() {
        super.loadData()
        getData()
    }

    override fun getData() {
//        if (isRefresh) {
//            binding.refreshLayout.finishRefreshWithNoMoreData()
//        }
        movieAdapter.data = listOf("1", "2", "3", "4", "5", "6")
        movieAdapter.notifyDataSetChanged()
    }

    companion object {
        fun newInstance(position: Int): MovieListFragment {
            val fragment = MovieListFragment()
            fragment.arguments = Bundle().apply { putInt("position", position) }
            fragment.logInfo = LogUtils.LogInfo("MovieListFragment$position")
            return fragment
        }
    }

    inner class MovieAdapter(var data: List<String>) : RecyclerView.Adapter<DataBindingViewHolder<ItemMovieListBinding>>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder<ItemMovieListBinding> {
            return DataBindingViewHolder(LayoutInflater.from(context).inflate(R.layout.item_movie_list, parent, false))
        }

        override fun onBindViewHolder(holder: DataBindingViewHolder<ItemMovieListBinding>, position: Int) {
            holder.binding.tvMovieTitle.text = data[position]
        }

        override fun getItemCount(): Int = data.size
    }
}