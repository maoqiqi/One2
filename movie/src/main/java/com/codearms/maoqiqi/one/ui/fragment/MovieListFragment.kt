package com.codearms.maoqiqi.one.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codearms.maoqiqi.databinding.binding
import com.codearms.maoqiqi.log.LogUtils
import com.codearms.maoqiqi.one.RecyclerViewDataBinding
import com.codearms.maoqiqi.one.base.BaseFragment
import com.codearms.maoqiqi.one.movie.R
import com.codearms.maoqiqi.one.movie.databinding.FragmentMovieListBinding

/**
 * 电影列表
 * link: https://github.com/maoqiqi/one
 * e-mail: fengqi.mao.march@gmail.com
 * author: March
 * date: 2021-03-04 21:01
 * version v1.0.0
 */
class MovieListFragment : BaseFragment() {

    private val binding: FragmentMovieListBinding by binding()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val position = arguments?.getInt("position", 0)
        binding.recyclerView
    }

    companion object {
        fun newInstance(position: Int): MovieListFragment {
            val fragment = MovieListFragment()
            fragment.arguments = Bundle().apply { putInt("position", position) }
            fragment.logInfo = LogUtils.LogInfo("MovieListFragment$position")
            return fragment
        }
    }

    class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewDataBinding<FragmentMovieListBinding>>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewDataBinding<FragmentMovieListBinding> {
            TODO("Not yet implemented")
        }

        override fun onBindViewHolder(holder: RecyclerViewDataBinding<FragmentMovieListBinding>, position: Int) {
            TODO("Not yet implemented")
        }

        override fun getItemCount(): Int {
            TODO("Not yet implemented")
        }
    }
}