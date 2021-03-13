package com.codearms.maoqiqi.one.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.alibaba.android.arouter.facade.annotation.Route
import com.codearms.maoqiqi.databinding.binding
import com.codearms.maoqiqi.log.LogUtils
import com.codearms.maoqiqi.one.MovieRoutePath
import com.codearms.maoqiqi.one.base.BaseFragment
import com.codearms.maoqiqi.one.listener.OnToolbarListener
import com.codearms.maoqiqi.one.movie.R
import com.codearms.maoqiqi.one.movie.databinding.FragmentMovieBinding
import com.flyco.tablayout.listener.OnTabSelectListener

/**
 * 电影
 * link: https://github.com/maoqiqi/one
 * e-mail: fengqi.mao.march@gmail.com
 * author: March
 * date: 2021-03-04 21:01
 * version v1.0.0
 */
@Route(path = MovieRoutePath.MOVIE_FRAGMENT)
class MovieFragment : BaseFragment() {

    private val binding: FragmentMovieBinding by binding()
    private val titles = arrayOf("正在热映", "即将上映")
    private val adapter: SectionsPagerAdapter by lazy { SectionsPagerAdapter(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        binding.viewPager.adapter = adapter
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.tabLayout.currentTab = position
            }
        })

        binding.tabLayout.setTabData(titles)
        binding.tabLayout.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                // binding.viewPager.currentItem = position
                binding.viewPager.setCurrentItem(position, true)
            }

            override fun onTabReselect(position: Int) {}
        })
    }

    override fun onResume() {
        super.onResume()
        if (activity is OnToolbarListener) (activity as OnToolbarListener).onToolbar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        if (isShow) inflater.inflate(R.menu.menu_search, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (isShow) LogUtils.v(logInfo, "item:${item.itemId}")
        return super.onOptionsItemSelected(item)
    }

    inner class SectionsPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

        override fun getItemCount(): Int = titles.size

        override fun createFragment(position: Int): Fragment = MovieListFragment.newInstance(position)
    }
}