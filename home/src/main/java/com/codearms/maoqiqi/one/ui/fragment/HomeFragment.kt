package com.codearms.maoqiqi.one.ui.fragment

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.alibaba.android.arouter.facade.annotation.Route
import com.codearms.maoqiqi.databinding.binding
import com.codearms.maoqiqi.log.LogUtils
import com.codearms.maoqiqi.one.AppUtils.getAppVersionCode
import com.codearms.maoqiqi.one.AppUtils.getAppVersionName
import com.codearms.maoqiqi.one.HomeRoutePath
import com.codearms.maoqiqi.one.base.BaseFragment
import com.codearms.maoqiqi.one.home.R
import com.codearms.maoqiqi.one.home.databinding.FragmentHomeBinding
import com.codearms.maoqiqi.one.listener.OnToolbarListener
import com.codearms.maoqiqi.one.viewmodel.HomeViewModel

/**
 * 首页
 * link: https://github.com/maoqiqi/one
 * e-mail: fengqi.mao.march@gmail.com
 * author: March
 * date: 2021-03-04 21:01
 * version v1.0.0
 */
@Route(path = HomeRoutePath.HOME_FRAGMENT)
class HomeFragment : BaseFragment() {

    private val binding: FragmentHomeBinding by binding()
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        binding.banner.addBannerLifecycleObserver(this)

//        viewModel.getBanner()
    }

    override fun onResume() {
        super.onResume()
        // activity?.javaClass?.getMethod("associateToolbar", Toolbar::class.java)?.invoke(activity, binding.toolbar)
        if (activity is OnToolbarListener) (activity as OnToolbarListener).onToolbar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        if (isShow) inflater.inflate(R.menu.menu_home, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (isShow) LogUtils.v(logInfo, "item:${item.itemId}")
        when (item.itemId) {
            R.id.menu_search -> {
                Toast.makeText(context, "${context.getAppVersionCode()}--${context.getAppVersionName()}", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}