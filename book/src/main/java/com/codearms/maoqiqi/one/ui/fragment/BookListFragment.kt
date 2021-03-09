package com.codearms.maoqiqi.one.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codearms.maoqiqi.databinding.binding
import com.codearms.maoqiqi.one.base.BaseFragment
import com.codearms.maoqiqi.one.book.R
import com.codearms.maoqiqi.one.book.databinding.FragmentBookListBinding

/**
 * 图书列表
 * link: https://github.com/maoqiqi/one
 * e-mail: fengqi.mao.march@gmail.com
 * author: March
 * date: 2021-03-04 21:01
 * version v1.0.0
 */
class BookListFragment : BaseFragment() {

    private val binding: FragmentBookListBinding by binding()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_book_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val position = arguments?.getInt("position", 0)
        binding.tv.text = "BookListFragment:$position"
    }

    companion object {
        fun newInstance(position: Int): BookListFragment {
            val args = Bundle()
            args.putInt("position", position)
            val fragment = BookListFragment()
            fragment.arguments = args
            return fragment
        }
    }
}