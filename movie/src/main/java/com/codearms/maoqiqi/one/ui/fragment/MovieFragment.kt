package com.codearms.maoqiqi.one.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.alibaba.android.arouter.facade.annotation.Route
import com.codearms.maoqiqi.one.base.BaseFragment
import com.codearms.maoqiqi.one.movie.R
import com.codearms.maoqiqi.one.movie.databinding.FragmentMovieBinding
import com.flyco.tablayout.listener.OnTabSelectListener
import java.lang.Exception

/**
 * 电影
 * author: March
 * date: 2020-11-01 21:01
 * version v1.0.0
 */
@Route(path = "/movie/fragment")
class MovieFragment : BaseFragment() {

    private val binding: FragmentMovieBinding by binding()
    private val titles = arrayOf("正在热映", "即将上映")

    private val adapter: SectionsPagerAdapter by lazy { SectionsPagerAdapter(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        try {
            activity?.javaClass?.getMethod("associateToolbar", Toolbar::class.java)?.invoke(activity, binding.toolbar)
        } catch (e: Exception) {
            e.printStackTrace()
        }
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_search, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    inner class SectionsPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

        override fun getItemCount(): Int {
            return titles.size
        }

        override fun createFragment(position: Int): Fragment {
            return MovieListFragment.newInstance(position)
        }
    }
}