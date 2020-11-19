package com.codearms.maoqiqi.one.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codearms.maoqiqi.one.base.BaseFragment
import com.codearms.maoqiqi.one.movie.R
import com.codearms.maoqiqi.one.movie.databinding.FragmentMovieListBinding

/**
 * TODO
 * author: March
 * date: 2020-11-01 21:01
 * version v1.0.0
 */
class MovieListFragment : BaseFragment() {

    private val binding: FragmentMovieListBinding by binding()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val position = arguments?.getInt("position", 0)

        binding.lifecycleOwner = this
        binding.tv.text = "MovieListFragment:$position"
    }

    companion object {
        fun newInstance(position: Int): MovieListFragment {
            val args = Bundle()
            args.putInt("position", position)
            val fragment = MovieListFragment()
            fragment.arguments = args
            return fragment
        }
    }
}