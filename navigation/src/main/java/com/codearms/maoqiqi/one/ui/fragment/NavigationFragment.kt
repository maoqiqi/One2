package com.codearms.maoqiqi.one.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.codearms.maoqiqi.android.IntentUtils.startActivity
import com.codearms.maoqiqi.databinding.binding
import com.codearms.maoqiqi.one.NavigationRoutePath
import com.codearms.maoqiqi.one.base.BaseFragment
import com.codearms.maoqiqi.one.navigation.R
import com.codearms.maoqiqi.one.navigation.databinding.FragmentNavigationBinding
import com.codearms.maoqiqi.one.ui.ScanCodeActivity
import com.codearms.maoqiqi.one.ui.SettingActivity
import com.google.android.material.navigation.NavigationView

/**
 * 导航
 * link: https://github.com/maoqiqi/one
 * e-mail: fengqi.mao.march@gmail.com
 * author: March
 * date: 2021-03-04 21:01
 * version v1.0.0
 */
@Route(path = NavigationRoutePath.NAVIGATION_FRAGMENT)
class NavigationFragment : BaseFragment(), View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private val binding: FragmentNavigationBinding by binding()
    private lateinit var tvUserName: TextView
    private lateinit var logoutMenu: MenuItem

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_navigation, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.navView.setNavigationItemSelectedListener(this)
        val navigationHeader = binding.navView.getHeaderView(0)
        // 扫码
        navigationHeader.findViewById<View>(R.id.iv_scan_code).setOnClickListener(this)
        // 头像
        navigationHeader.findViewById<View>(R.id.iv_avatar).setOnClickListener(this)
        // 用户名
        tvUserName = navigationHeader.findViewById(R.id.tv_user_name)
        tvUserName.setOnClickListener(this)

        // 设置菜单点击事件
        binding.navView.setNavigationItemSelectedListener(this)
        logoutMenu = binding.navView.menu.findItem(R.id.nav_logout)

        // 设置
        binding.tvSetting.setOnClickListener(this)
        // 夜间
        binding.tvMode.setOnClickListener(this)
        // 温度地址
        binding.layoutInfo.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
//            R.id.iv_avatar -> WebViewActivity.start(this, getString(R.string.project_git))
            R.id.iv_scan_code -> requireActivity().startActivity(ScanCodeActivity::class.java)
//            R.id.tv_user_name ->
            R.id.tv_setting -> requireActivity().startActivity(SettingActivity::class.java)
//            R.id.tv_mode -> ToastUtils.show("开发中")
//            R.id.tv_weather -> { }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_project -> ARouter.getInstance().build(NavigationRoutePath.NAVIGATION_PROJECT).navigation()
            R.id.nav_update -> {
                binding.navView.menu.findItem(R.id.nav_update).actionView.visibility = View.GONE
                ARouter.getInstance().build(NavigationRoutePath.NAVIGATION_UPDATE).navigation()
            }
            R.id.nav_scan_code -> ARouter.getInstance().build(NavigationRoutePath.NAVIGATION_SCAN_CODE).navigation()
            R.id.nav_problem -> ARouter.getInstance().build(NavigationRoutePath.NAVIGATION_PROBLEM).navigation()
            R.id.nav_about -> ARouter.getInstance().build(NavigationRoutePath.NAVIGATION_ABOUT).navigation()
            R.id.nav_donate -> ARouter.getInstance().build(NavigationRoutePath.NAVIGATION_DONATE).navigation()
        }
        return true
    }
}