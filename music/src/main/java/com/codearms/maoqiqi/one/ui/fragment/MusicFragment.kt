package com.codearms.maoqiqi.one.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.alibaba.android.arouter.facade.annotation.Route
import com.codearms.maoqiqi.one.base.BaseFragment
import com.codearms.maoqiqi.one.music.R
import com.codearms.maoqiqi.one.music.databinding.FragmentMusicBinding
import com.google.android.material.tabs.TabLayout

/**
 * 音乐
 * author: March
 * date: 2020-11-01 21:01
 * version v1.0.0
 */
@Route(path = "/music/fragment")
class MusicFragment : BaseFragment() {

    private val binding: FragmentMusicBinding by binding()
    private val titles by lazy { resources.getStringArray(R.array.music_array) }
    private val adapter: SectionsPagerAdapter by lazy { SectionsPagerAdapter(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_music, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.viewPager.adapter = adapter
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                // binding.tabLayout. = position
                // binding.tabLayout.selectedTabPosition = position
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

    inner class SectionsPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

        override fun getItemCount(): Int {
            return titles.size
        }

        override fun createFragment(position: Int): Fragment {
            return MusicListFragment.newInstance(position)
        }
    }
}