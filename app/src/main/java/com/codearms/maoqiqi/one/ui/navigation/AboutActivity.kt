package com.codearms.maoqiqi.one.ui.navigation

import android.os.Bundle
import com.codearms.maoqiqi.one.R
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.databinding.ActivityAboutBinding

/**
 * TODO
 * author: March
 * date: 2020-11-01 21:01
 * version v1.0.0
 */
class AboutActivity : BaseActivity() {

    private val binding: ActivityAboutBinding by binding(R.layout.activity_about)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        setSupportActionBar(binding.toolbar)
    }
}