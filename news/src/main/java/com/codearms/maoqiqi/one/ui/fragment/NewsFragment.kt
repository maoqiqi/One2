package com.codearms.maoqiqi.one.ui.fragment

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.alibaba.android.arouter.facade.annotation.Route
import com.codearms.maoqiqi.databinding.binding
import com.codearms.maoqiqi.log.LogUtils
import com.codearms.maoqiqi.one.AppBarStateChangeListener
import com.codearms.maoqiqi.one.AppUtils.getAppVersionCode
import com.codearms.maoqiqi.one.AppUtils.getAppVersionName
import com.codearms.maoqiqi.one.NewsRoutePath
import com.codearms.maoqiqi.one.StatusBarUtils.getSystemUiVisibility
import com.codearms.maoqiqi.one.StatusBarUtils.setStatusBarModel
import com.codearms.maoqiqi.one.base.BaseFragment
import com.codearms.maoqiqi.one.listener.OnToolbarListener
import com.codearms.maoqiqi.one.news.R
import com.codearms.maoqiqi.one.news.databinding.FragmentNewsBinding
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayout

/**
 * 新闻
 * link: https://github.com/maoqiqi/one
 * e-mail: fengqi.mao.march@gmail.com
 * author: March
 * date: 2021-03-04 21:01
 * version v1.0.0
 */
@Route(path = NewsRoutePath.NEWS_FRAGMENT)
class NewsFragment : BaseFragment() {

    private val binding: FragmentNewsBinding by binding()
    private val uiOptions: Int by lazy { requireActivity().getSystemUiVisibility() }
    private val titles = arrayOf(
        "推荐", "热点", "社会", "娱乐", "情感", "故事", "小说", "星座", "科技", "财经",
        "体育", "军事", "教育", "历史", "搞笑", "奇闻", "游戏", "时尚", "养生", "旅行"
    )
    private val adapter: SectionsPagerAdapter by lazy { SectionsPagerAdapter(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.appBarLayout.addOnOffsetChangedListener(object : AppBarStateChangeListener(true) {
            override fun onStateChanged(appBarLayout: AppBarLayout, state: State, percentage: Float) {
                appBarLayout.setBackgroundResource(getAppBarLayoutBackgroundResource(state, percentage))
            }
        })
        binding.viewPager.adapter = adapter
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.tabLayout.getTabAt(position)?.select()
            }
        })

        titles.forEach { title -> binding.tabLayout.apply { addTab(newTab().setText(title)) } }
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.viewPager.setCurrentItem(tab.position, true)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    override fun onResume() {
        super.onResume()
        if (activity is OnToolbarListener) (activity as OnToolbarListener).onToolbar(binding.toolbar)
    }

    private fun getAppBarLayoutBackgroundResource(state: AppBarStateChangeListener.State, percentage: Float) = when (state) {
        AppBarStateChangeListener.State.EXPANDED -> {
            requireActivity().setStatusBarModel(uiOptions)
            R.drawable.color_news_gradient
        }
        AppBarStateChangeListener.State.COLLAPSED -> {
            requireActivity().setStatusBarModel(uiOptions, true)
            R.color.white
        }
        else -> {
            if (percentage <= 0.5) {
                requireActivity().setStatusBarModel(uiOptions)
                R.drawable.color_news_gradient
            } else {
                requireActivity().setStatusBarModel(uiOptions, true)
                R.color.white
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        if (isShow) {
            inflater.inflate(R.menu.menu_search, menu)
            inflater.inflate(R.menu.menu_news, menu)
        }
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

    inner class SectionsPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

        override fun getItemCount(): Int = titles.size

        override fun createFragment(position: Int): Fragment = NewsListFragment.newInstance(position)
    }
}