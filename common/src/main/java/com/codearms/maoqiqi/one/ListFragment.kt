package com.codearms.maoqiqi.one

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codearms.maoqiqi.databinding.binding
import com.codearms.maoqiqi.one.base.BaseFragment
import com.codearms.maoqiqi.one.common.R
import com.codearms.maoqiqi.one.common.databinding.FragmentListBinding

abstract class ListFragment : BaseFragment() {

    protected val binding: FragmentListBinding by binding()
    protected var isRefresh = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.refreshLayout.setOnRefreshListener {
            isRefresh = true
            getData()
        }
        binding.refreshLayout.setOnLoadMoreListener {
            isRefresh = false
            getData()
        }
    }

    protected abstract fun getData()
}