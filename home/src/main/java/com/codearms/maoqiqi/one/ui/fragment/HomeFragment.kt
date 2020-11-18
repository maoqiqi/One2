package com.codearms.maoqiqi.one.ui.fragment

import android.os.Bundle
import android.view.*
import com.alibaba.android.arouter.facade.annotation.Route
import com.codearms.maoqiqi.one.base.BaseFragment
import com.codearms.maoqiqi.one.home.R
import com.codearms.maoqiqi.one.home.databinding.FragmentHomeBinding
import com.codearms.maoqiqi.one.listener.OnToolbarListener

/**
 * 首页
 * author: March
 * date: 2020-11-01 21:01
 * version v1.0.0
 */
@Route(path = "/home/fragment")
class HomeFragment : BaseFragment() {

    private val binding: FragmentHomeBinding by binding()
//    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // activity?.javaClass?.getMethod("associateToolbar", Toolbar::class.java)?.invoke(activity, binding.toolbar)
        if (activity is OnToolbarListener) (activity as OnToolbarListener).onToolbar(binding.toolbar)
        setHasOptionsMenu(true)

        binding.banner.addBannerLifecycleObserver(this)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_home, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}