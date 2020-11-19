package com.codearms.maoqiqi.one.ui

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.listener.OnToolbarListener
import com.codearms.maoqiqi.one.news.R

class NewsActivity : BaseActivity(), OnToolbarListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onToolbar(toolbar: Toolbar?) {
        setSupportActionBar(toolbar)
    }
}