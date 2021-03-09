package com.codearms.maoqiqi.one.ui

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.codearms.maoqiqi.one.HomeRoutePath
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.home.R
import com.codearms.maoqiqi.one.listener.OnToolbarListener

/**
 * 主页
 * link: https://github.com/maoqiqi/one
 * e-mail: fengqi.mao.march@gmail.com
 * author: March
 * date: 2021-03-04 21:01
 * version v1.0.0
 */
@Route(path = HomeRoutePath.HOME_MAIN)
class HomeMainActivity : BaseActivity(), OnToolbarListener {

    private var fragment: Fragment? = null
    private val tag = "home_fragment_tag"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        if (savedInstanceState != null) fragment = supportFragmentManager.findFragmentByTag(tag)
        if (fragment == null) fragment = ARouter.getInstance().build(HomeRoutePath.HOME_FRAGMENT).navigation() as? Fragment
        val ft = supportFragmentManager.beginTransaction()
        fragment?.let { if (!it.isAdded) ft.add(R.id.container, it, tag).commit() else ft.show(it).commit() }
    }

    override fun onToolbar(toolbar: Toolbar?) {
        setSupportActionBar(toolbar)
    }
}