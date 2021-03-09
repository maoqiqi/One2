package com.codearms.maoqiqi.one

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter
import com.codearms.maoqiqi.databinding.binding
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.databinding.ActivityMainBinding
import com.codearms.maoqiqi.one.listener.OnToolbarListener
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView

/**
 * MainActivity
 * author: March
 * date: 2020-11-01 21:01
 * version v1.0.0
 */
class MainActivity : BaseActivity(), OnToolbarListener {

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
        "/home/fragment",
        "/news/fragment",
        "/book/fragment",
        "/music/fragment",
        "/movie/fragment",
    )
    private val fragments: Array<Fragment?> = arrayOfNulls(colors.size)
    private val badgeViews: Array<View?> = arrayOfNulls(colors.size)
    private var previousFragment: Fragment? = null
    private var badges: BooleanArray = booleanArrayOf(true, true, true, true, true)
    private var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(application)

        Log.e("info", getString(R.string.name))
//        Log.e("info", TestConflict.A)
        Log.e("info", CommonConflict.A)
        CommonConflict.a()

        val action: String? = intent?.action
        val data: Uri? = intent?.data
        Log.i("info", "action=$action,data=$data")

        // Figure out what to do based on the intent type
        if (intent?.type?.startsWith("image/") == true) {
            // Handle intents with image data ...
        } else if (intent?.type == "text/plain") {
            // Handle intents with text ...
        }

        savedInstanceState?.let { restoreInstanceState(it) }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = Color.TRANSPARENT
        }
        // 蒙层颜色
        // binding.drawerLayout.setScrimColor(Color.RED)
        setupBottomNavigationMenuView()
        // 默认选中
        // binding.bottomNavView.selectedItemId = R.id.nav_home
        binding.bottomNavView.apply { selectedItemId = menu[position].itemId }
        // 抽屉栏
//        setNavigationView()
        if (savedInstanceState != null) fragment = supportFragmentManager.findFragmentByTag(NavigationRoutePath.NAVIGATION_FRAGMENT)
        if (fragment == null) fragment = ARouter.getInstance().build(NavigationRoutePath.NAVIGATION_FRAGMENT).navigation() as? Fragment
        val ft = supportFragmentManager.beginTransaction()
        fragment?.let { if (!it.isAdded) ft.add(R.id.navigation_container, it, NavigationRoutePath.NAVIGATION_FRAGMENT).commit() else ft.show(it).commit() }
    }

    private var fragment: Fragment? = null

    // 恢复数据
    private fun restoreInstanceState(savedInstanceState: Bundle) {
        position = savedInstanceState.getInt("position")
        badges = savedInstanceState.getBooleanArray("badges") ?: booleanArrayOf(true, true, true, true, true)
        for ((index, fragment) in fragments.withIndex()) {
            if (fragment == null) {
                fragments[index] = supportFragmentManager.findFragmentByTag(paths[index])
            }
        }
    }

    // 保存数据
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("position", position)
        outState.putBooleanArray("badges", badges)
        super.onSaveInstanceState(outState)
    }

    override fun onToolbar(toolbar: Toolbar?) {
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close)
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

    private fun getFragment(position: Int): Fragment? {
        if (fragments[position] == null)
            fragments[position] = ARouter.getInstance().build(paths[position]).navigation() as? Fragment
        return fragments[position]
    }

    @SuppressLint("RestrictedApi")
    private fun setupBottomNavigationMenuView() {
        val menuView: BottomNavigationMenuView = binding.bottomNavView.getChildAt(0) as BottomNavigationMenuView
        for (i in 0 until menuView.childCount) {
            // 小红点
            badgeViews[i] = LayoutInflater.from(this).inflate(R.layout.layout_badge, null)
            badgeViews[i]?.visibility = if (badges[i]) View.VISIBLE else View.GONE
            // 设置BottomNavigationItemView
            val itemView: BottomNavigationItemView = menuView.getChildAt(i) as BottomNavigationItemView
            val colorStateList: ColorStateList? = ContextCompat.getColorStateList(this, colors[i])
            itemView.setIconTintList(colorStateList)
            itemView.setTextColor(colorStateList)
            itemView.addView(badgeViews[i])
        }
        binding.bottomNavView.setOnNavigationItemSelectedListener { item ->
            position = getPosition(item.itemId)
            // 状态栏颜色
            binding.drawerLayout.setStatusBarBackground(statusColors[position])
            // 小红点是否需要展示
            badges[position] = false
            badgeViews[position]?.visibility = if (badges[position]) View.VISIBLE else View.GONE
            // 切换Fragment
            switchFragment(previousFragment, getFragment(position), paths[position])
            true
        }
    }

    private fun switchFragment(from: Fragment?, to: Fragment?, tag: String) {
        if (to != null && from !== to) { // from != to 才切换
            previousFragment = to
            val ft = supportFragmentManager.beginTransaction()

            // from隐藏
            if (from != null) ft.hide(from)
            if (!to.isAdded) {
                // 没有被添加,添加to
                ft.add(R.id.container, to, tag).commit()
            } else {
                // 已经被添加,显示to
                ft.show(to).commit()
            }
        }
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START))
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        else super.onBackPressed()
    }
}