package com.codearms.maoqiqi.one.ui.navigation

import android.graphics.Color
import android.os.Bundle
import com.codearms.maoqiqi.one.R
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.databinding.ActivityProjectBinding

/**
 * TODO
 * author: March
 * date: 2020-10-16 15:02
 * version v1.3.0
 */
class ProjectActivity : BaseActivity() {

    private val binding: ActivityProjectBinding by binding(R.layout.activity_project)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        window.statusBarColor = Color.TRANSPARENT
    }
}