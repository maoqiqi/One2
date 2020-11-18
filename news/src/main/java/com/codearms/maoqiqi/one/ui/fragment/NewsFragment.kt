package com.codearms.maoqiqi.one.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.alibaba.android.arouter.facade.annotation.Route
import com.codearms.maoqiqi.one.base.BaseFragment
import com.codearms.maoqiqi.one.listener.OnToolbarListener
import com.codearms.maoqiqi.one.news.R
import com.codearms.maoqiqi.one.news.databinding.FragmentNewsBinding
import com.google.android.material.tabs.TabLayout

/**
 * 新闻
 * author: March
 * date: 2020-11-01 21:01
 * version v1.0.0
 */
@Route(path = "/news/fragment")
class NewsFragment : BaseFragment() {

    private val binding: FragmentNewsBinding by binding()
    private val titles = arrayOf(
        "推荐", "热点", "社会", "娱乐", "情感", "故事", "小说", "星座", "科技", "财经",
        "体育", "军事", "教育", "历史", "搞笑", "奇闻", "游戏", "时尚", "养生", "旅行"
    )
    private val adapter: SectionsPagerAdapter by lazy { SectionsPagerAdapter(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // activity?.javaClass?.getMethod("associateToolbar", Toolbar::class.java)?.invoke(activity, binding.toolbar)
        if (activity is OnToolbarListener) (activity as OnToolbarListener).onToolbar(binding.toolbar)
        setHasOptionsMenu(true)

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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_search, menu)
        inflater.inflate(R.menu.menu_news, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    inner class SectionsPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

        override fun getItemCount(): Int = titles.size

        override fun createFragment(position: Int): Fragment = NewsListFragment.newInstance(position)
    }
}