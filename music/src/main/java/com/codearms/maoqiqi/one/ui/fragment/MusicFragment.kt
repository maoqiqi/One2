package com.codearms.maoqiqi.one.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.alibaba.android.arouter.facade.annotation.Route
import com.codearms.maoqiqi.databinding.binding
import com.codearms.maoqiqi.log.LogUtils
import com.codearms.maoqiqi.one.AppBarStateChangeListener
import com.codearms.maoqiqi.one.MusicRoutePath
import com.codearms.maoqiqi.one.base.BaseFragment
import com.codearms.maoqiqi.one.listener.OnToolbarListener
import com.codearms.maoqiqi.one.music.R
import com.codearms.maoqiqi.one.music.databinding.FragmentMusicBinding
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayout

/**
 * 音乐
 * link: https://github.com/maoqiqi/one
 * e-mail: fengqi.mao.march@gmail.com
 * author: March
 * date: 2021-03-04 21:01
 * version v1.0.0
 */
@Route(path = MusicRoutePath.MUSIC_FRAGMENT)
class MusicFragment : BaseFragment() {

    private val binding: FragmentMusicBinding by binding()
    private val titles by lazy { resources.getStringArray(R.array.music_array) }
    private val adapter: SectionsPagerAdapter by lazy { SectionsPagerAdapter(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        // 解决滑动到顶部还显示部分标题
        val layoutParams = binding.view.layoutParams
        val viewHeight = layoutParams.height
        binding.appBarLayout.addOnOffsetChangedListener(object : AppBarStateChangeListener(true) {
            override fun onStateChanged(appBarLayout: AppBarLayout, state: State, percentage: Float) {
                layoutParams.height = (viewHeight * percentage).toInt()
                binding.view.layoutParams = layoutParams
            }
        })
        binding.viewPager.offscreenPageLimit = 1
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

        override fun createFragment(position: Int): Fragment = MusicListFragment.newInstance(position)
    }
}