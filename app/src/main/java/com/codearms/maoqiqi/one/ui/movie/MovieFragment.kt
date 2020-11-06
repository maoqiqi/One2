package com.codearms.maoqiqi.one.ui.movie

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.codearms.maoqiqi.one.MainActivity
import com.codearms.maoqiqi.one.R
import com.codearms.maoqiqi.one.base.BaseFragment
import com.codearms.maoqiqi.one.databinding.FragmentMovieBinding
import com.flyco.tablayout.listener.OnTabSelectListener
import java.util.*

/**
 * 电影
 * author: March
 * date: 2020-11-01 21:01
 * version v1.0.0
 */
class MovieFragment : BaseFragment() {

    private val binding: FragmentMovieBinding by binding()
    private val titles = arrayOf("正在热映", "即将上映")
    private val adapter: SectionsPagerAdapter by lazy { SectionsPagerAdapter(childFragmentManager) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as MainActivity).associateToolbar(binding.toolbar)
        setHasOptionsMenu(true)

        for (i in titles.indices) {
            adapter.addFragment(titles[i], getFragment(i))
        }

        binding.viewPager.adapter = adapter
        binding.viewPager.offscreenPageLimit = 1
        binding.viewPager.currentItem = 0
        binding.viewPager.addOnPageChangeListener(MyPageChangeListener())

        binding.tabLayout.setTabData(titles)
        binding.tabLayout.setOnTabSelectListener(MyTabSelectListener())
    }

    private fun getFragment(type: Int): Fragment {
        // return MovieListFragment.newInstance(type, "561", "", "")
        return Fragment()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_search, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        // 注意,FragmentPagerAdapter是一次性将所有页卡都加载完毕,没有销毁的。
        // 而FragmentStatePagerAdapter并不是一次性将页卡都加载完毕,而是默认每次加载进三个页卡,当前页卡被滑动消失就会被销毁。
        // 这是它们的区别。因此如果页卡较多,建议采用FragmentStatePagerAdapter适配器。
        private val mFragments: MutableList<Fragment> = ArrayList<Fragment>()
        private val mFragmentTitles: MutableList<String> = ArrayList()

        fun addFragment(title: String, fragment: Fragment) {
            mFragmentTitles.add(title)
            mFragments.add(fragment)
        }

        override fun getItem(position: Int): Fragment {
            return mFragments[position]
        }

        override fun getCount(): Int {
            return mFragments.size
        }

        override fun getPageTitle(position: Int): CharSequence {
            return mFragmentTitles[position]
        }
    }

    private inner class MyPageChangeListener : ViewPager.OnPageChangeListener {

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

        override fun onPageSelected(position: Int) {
            binding.tabLayout.currentTab = position
        }

        override fun onPageScrollStateChanged(state: Int) {}
    }

    private inner class MyTabSelectListener : OnTabSelectListener {
        override fun onTabSelect(position: Int) {
            binding.viewPager.currentItem = position
        }

        override fun onTabReselect(position: Int) {}
    }
}