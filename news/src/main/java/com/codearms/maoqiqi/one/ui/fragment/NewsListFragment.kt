package com.codearms.maoqiqi.one.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codearms.maoqiqi.databinding.binding
import com.codearms.maoqiqi.one.base.BaseFragment
import com.codearms.maoqiqi.one.news.R
import com.codearms.maoqiqi.one.news.databinding.FragmentNewsListBinding

/**
 * 新闻列表
 * link: https://github.com/maoqiqi/one
 * e-mail: fengqi.mao.march@gmail.com
 * author: March
 * date: 2021-03-04 21:01
 * version v1.0.0
 */
class NewsListFragment : BaseFragment() {

    private val binding: FragmentNewsListBinding by binding()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val position = arguments?.getInt("position", 0)
        binding.tv.text = "NewsListFragment:$position"
    }

    companion object {
        fun newInstance(position: Int): NewsListFragment {
            val args = Bundle()
            args.putInt("position", position)
            val fragment = NewsListFragment()
            fragment.arguments = args
            return fragment
        }
    }
}