package com.codearms.maoqiqi.one.ui.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codearms.maoqiqi.one.MainActivity
import com.codearms.maoqiqi.one.R
import com.codearms.maoqiqi.one.base.BaseFragment
import com.codearms.maoqiqi.one.databinding.FragmentBookBinding

/**
 * TODO
 * author: March
 * date: 2020-10-16 15:02
 * version v1.3.0
 */
class BookFragment : BaseFragment() {

    private val binding: FragmentBookBinding by binding()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_book, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.text.text = "BookFragment"
        (activity as MainActivity).associateToolbar(binding.toolbar)
    }
}