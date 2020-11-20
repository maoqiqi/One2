package com.codearms.maoqiqi.one.ui

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.home.R
import com.codearms.maoqiqi.one.listener.OnToolbarListener

/**
 * 首页
 * author: March
 * date: 2020-11-01 21:01
 * version v1.0.0
 */
class HomeActivity : BaseActivity(), OnToolbarListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun onToolbar(toolbar: Toolbar?) {
        setSupportActionBar(toolbar)
    }
}