package com.codearms.maoqiqi.one.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codearms.maoqiqi.one.MainActivity
import com.codearms.maoqiqi.one.R
import com.codearms.maoqiqi.one.base.BaseFragment
import com.codearms.maoqiqi.one.databinding.FragmentNewsBinding

/**
 * 新闻
 * author: March
 * date: 2020-11-01 21:01
 * version v1.0.0
 */
class NewsFragment : BaseFragment() {

    private val binding: FragmentNewsBinding by binding()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.text.text = "NewsFragment"
        (activity as MainActivity).associateToolbar(binding.toolbar)
    }
}