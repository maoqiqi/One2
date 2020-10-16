package com.codearms.maoqiqi.one

import android.graphics.Color
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.databinding.ActivityMainBinding

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

//        setSupportActionBar(binding.toolbar)
//        binding.drawerLayout.setScrimColor(Color.RED)
//        binding.drawerLayout.setStatusBarBackgroundColor(Color.GREEN)

//        navController = findNavController(R.id.nav_host_fragment)
//        appBarConfiguration = AppBarConfiguration(
//            setOf(R.id.nav_project, R.id.nav_update, R.id.nav_scan_code, R.id.nav_problem, R.id.nav_about), binding.drawerLayout
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        binding.navView.setupWithNavController(navController)

//        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.drawer_open, R.string.drawer_close)
//        toggle.syncState()
//        binding.drawerLayout.addDrawerListener(toggle)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}