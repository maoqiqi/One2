package com.codearms.maoqiqi.one

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView

/**
 * MainActivity
 * author: March
 * date: 2020-11-01 21:01
 * version v1.0.0
 */
class MainActivity : BaseActivity() {

    private val binding: ActivityMainBinding by binding(R.layout.activity_main)
    private val statusColors: IntArray = intArrayOf(
        R.color.colorHome,
        R.color.colorNews,
        R.color.colorBook,
        R.color.colorMusic,
        R.color.colorMovie
    )
    private val colors: IntArray = intArrayOf(
        R.color.color_home_selector,
        R.color.color_news_selector,
        R.color.color_book_selector,
        R.color.color_music_selector,
        R.color.color_movie_selector
    )
    private val paths: Array<String> = arrayOf(
        "/movie/fragment",
        "/movie/fragment",
        "/movie/fragment",
        "/movie/fragment",
        "/movie/fragment"
    )
    private val fragments: Array<Fragment?> = arrayOfNulls(colors.size)
    private val badgeViews: Array<View?> = arrayOfNulls(colors.size)
    private var previousFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(application)

        Log.e("info", getString(R.string.name))
        Log.e("info", TestConflict.A)
        Log.e("info", CommonConflict.A)
        CommonConflict.a()

        window.statusBarColor = Color.TRANSPARENT
        binding.lifecycleOwner = this
        // 蒙层颜色
        // binding.drawerLayout.setScrimColor(Color.RED)
        // 状态栏颜色
        binding.drawerLayout.setStatusBarBackground(statusColors[0])
        setupBottomNavigationMenuView()
        // binding.bottomNavView.getChildAt(0).setSelected(true)
        binding.bottomNavView.selectedItemId = R.id.nav_home
        setNavigationView()
    }

    fun associateToolbar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
        val toggle =
            ActionBarDrawerToggle(this, binding.drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close)
        toggle.syncState()
        binding.drawerLayout.addDrawerListener(toggle)
    }

    private fun getPosition(itemId: Int) = when (itemId) {
        R.id.nav_home -> 0
        R.id.nav_news -> 1
        R.id.nav_book -> 2
        R.id.nav_music -> 3
        R.id.nav_movie -> 4
        else -> -1
    }

    private fun getFragment(itemId: Int): Fragment? {
        val position = getPosition(itemId)
        if (fragments[position] == null)
            fragments[position] = ARouter.getInstance().build(paths[position]).navigation() as Fragment
        return fragments[position]
    }

    @SuppressLint("RestrictedApi")
    private fun setupBottomNavigationMenuView() {
        val menuView: BottomNavigationMenuView = binding.bottomNavView.getChildAt(0) as BottomNavigationMenuView
        for (i in 0 until menuView.childCount) {
            badgeViews[i] = LayoutInflater.from(this).inflate(R.layout.layout_badge, null)
            val itemView: BottomNavigationItemView = menuView.getChildAt(i) as BottomNavigationItemView
            val colorStateList: ColorStateList? = ContextCompat.getColorStateList(this, colors[i])
            itemView.setIconTintList(colorStateList)
            itemView.setTextColor(colorStateList)
            itemView.addView(badgeViews[i])
        }
        binding.bottomNavView.setOnNavigationItemSelectedListener { item ->
            binding.drawerLayout.setStatusBarBackground(statusColors[getPosition(item.itemId)])
            badgeViews[getPosition(item.itemId)]?.visibility = View.GONE
            item.isChecked = true
            switchFragment(previousFragment, getFragment(item.itemId))
            true
        }
    }

    private fun switchFragment(from: Fragment?, to: Fragment?) {
        if (to != null && from !== to) { // from != to 才切换
            previousFragment = to
            val ft = supportFragmentManager.beginTransaction()

            // from隐藏
            if (from != null) ft.hide(from)
            if (!to.isAdded) {
                // 没有被添加,添加to
                ft.add(R.id.container, to).commit()
            } else {
                // 已经被添加,显示to
                ft.show(to).commit()
            }
        }
    }

    private fun setNavigationView() {
        binding.navView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_project -> ARouter.getInstance().build("/navigation/project").navigation()
                R.id.nav_update -> {
                    binding.navView.menu.findItem(R.id.nav_update).actionView.visibility = View.GONE
                    ARouter.getInstance().build("/navigation/update").navigation()
                }
                R.id.nav_scan_code -> ARouter.getInstance().build("/navigation/scan_code").navigation()
                R.id.nav_problem -> ARouter.getInstance().build("/navigation/problem").navigation()
                R.id.nav_about -> ARouter.getInstance().build("/navigation/about").navigation()
            }
            true
        }
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START))
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        else super.onBackPressed()
    }
}