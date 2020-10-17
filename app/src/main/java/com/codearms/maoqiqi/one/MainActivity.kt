package com.codearms.maoqiqi.one

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.databinding.ActivityMainBinding
import com.codearms.maoqiqi.one.ui.navigation.*

/**
 * TODO
 * author: March
 * date: 2020/10/16 15:08
 * version v1.0.0
 */
class MainActivity : BaseActivity() {

    private val binding: ActivityMainBinding by binding(R.layout.activity_main)
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        window.statusBarColor = Color.TRANSPARENT
        // 蒙层颜色
        // binding.drawerLayout.setScrimColor(Color.RED)
        // 状态栏颜色
        binding.drawerLayout.setStatusBarBackgroundColor(Color.BLACK)

//        val navController = findNavController(R.id.nav_host_fragment)
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(R.id.nav_home, R.id.nav_news, R.id.nav_book, R.id.nav_music, R.id.nav_movie)
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        binding.navView.setOnNavigationItemSelectedListener { item ->
//            Log.e("info", "setOnNavigationItemSelectedListener:${item.itemId}")
//            when (item.itemId) {
//
//            }
//            false
//        }
//        binding.navView.setupWithNavController(navController)

        setSupportActionBar(binding.toolbar)

//        navController = findNavController(R.id.nav_host_fragment)
//        appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.nav_project,
//                R.id.nav_update,
//                R.id.nav_scan_code,
//                R.id.nav_problem,
//                R.id.nav_about
//            ), binding.drawerLayout
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        binding.navView.setupWithNavController(navController)

//        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.drawer_open, R.string.drawer_close)
//        toggle.syncState()
//        binding.drawerLayout.addDrawerListener(toggle)

        binding.navView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_project -> startActivity(Intent(this, ProjectActivity::class.java))
                R.id.nav_update -> startActivity(Intent(this, UpdateActivity::class.java))
                R.id.nav_scan_code -> startActivity(Intent(this, ScanCodeActivity::class.java))
                R.id.nav_problem -> startActivity(Intent(this, ProblemActivity::class.java))
                R.id.nav_about -> startActivity(Intent(this, AboutActivity::class.java))
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