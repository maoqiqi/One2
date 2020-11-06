package com.codearms.maoqiqi.one.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.codearms.maoqiqi.one.MainActivity
import com.codearms.maoqiqi.one.R
import com.codearms.maoqiqi.one.base.BaseFragment
import com.codearms.maoqiqi.one.databinding.FragmentHomeBinding

/**
 * 首页
 * author: March
 * date: 2020-11-01 21:01
 * version v1.0.0
 */
class HomeFragment : BaseFragment() {

    private val binding: FragmentHomeBinding by binding()
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.text.text = "HomeFragment"
        (activity as MainActivity).associateToolbar(binding.toolbar)
    }
}