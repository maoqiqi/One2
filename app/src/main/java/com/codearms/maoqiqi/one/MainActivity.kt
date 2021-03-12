package com.codearms.maoqiqi.one

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter
import com.codearms.maoqiqi.databinding.binding
import com.codearms.maoqiqi.one.ColorStateListUtils.createColorStateList
import com.codearms.maoqiqi.one.FragmentManagerUtils.addFragment
import com.codearms.maoqiqi.one.FragmentManagerUtils.switchFragment
import com.codearms.maoqiqi.one.StatusBarUtils.setFullScreen
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
    private val ids: IntArray = intArrayOf(R.id.nav_home, R.id.nav_news, R.id.nav_book, R.id.nav_music, R.id.nav_movie)
    private val colors: IntArray = intArrayOf(R.color.color_home, R.color.color_news, R.color.color_book, R.color.color_music, R.color.color_movie)
    private val paths: Array<String> = arrayOf("/home/fragment", "/news/fragment", "/book/fragment", "/music/fragment", "/movie/fragment")
    private val fragments: Array<Fragment?> = arrayOfNulls(colors.size)
    private val badgeViews: Array<View?> = arrayOfNulls(colors.size)
    private var previousFragment: Fragment? = null
    private var badges: BooleanArray = booleanArrayOf(true, true, true, true, true)
    private var position = 0

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        Log.e("mfq","onWindowFocusChanged")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("mfq","onCreate")
        setFullScreen(true, true)
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
        // 蒙层颜色
        // binding.drawerLayout.setScrimColor(Color.RED)
        setupBottomNavigationMenuView()
        // 默认选中
        binding.bottomNavView.selectedItemId = ids[position]
        // binding.bottomNavView.apply { selectedItemId = menu[position].itemId }
        // 抽屉栏
        val newsFragment = ARouter.getInstance().build(NavigationRoutePath.NAVIGATION_FRAGMENT).navigation() as? Fragment
        addFragment(R.id.navigation_container, newsFragment, NavigationRoutePath.NAVIGATION_FRAGMENT, savedInstanceState)
    }

    // 恢复数据
    private fun restoreInstanceState(savedInstanceState: Bundle) {
        position = savedInstanceState.getInt("position")
        badges = savedInstanceState.getBooleanArray("badges") ?: booleanArrayOf(true, true, true, true, true)
        fragments.forEachIndexed { index, fragment ->
            if (fragment == null) fragments[index] = supportFragmentManager.findFragmentByTag(paths[index])
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

    private fun getPosition(itemId: Int): Int {
        ids.forEachIndexed { index, value -> if (value == itemId) return index }
        return -1
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
            val colorStateList = createColorStateList(colors[i], R.color.color_text_secondary)
            itemView.setIconTintList(colorStateList)
            itemView.setTextColor(colorStateList)
            itemView.addView(badgeViews[i])
        }
        binding.bottomNavView.setOnNavigationItemSelectedListener { item ->
            position = getPosition(item.itemId)
            // 状态栏颜色
            // binding.drawerLayout.setStatusBarBackground(colors[position])
            // 小红点是否需要展示
            badges[position] = false
            badgeViews[position]?.visibility = if (badges[position]) View.VISIBLE else View.GONE
            // 切换Fragment
            previousFragment = switchFragment(R.id.container, previousFragment, getFragment(position), paths[position])
            true
        }
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START))
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        else super.onBackPressed()
    }
}