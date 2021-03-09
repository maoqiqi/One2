package com.codearms.maoqiqi.one.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.codearms.maoqiqi.databinding.binding
import com.codearms.maoqiqi.one.NavigationRoutePath
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.navigation.R
import com.codearms.maoqiqi.one.navigation.databinding.ActivityProjectBinding
import com.codearms.maoqiqi.one.utils.ShareUtils

/**
 * 项目介绍
 * link: https://github.com/maoqiqi/one
 * e-mail: fengqi.mao.march@gmail.com
 * author: March
 * date: 2021-03-04 21:01
 * version v1.0.0
 */
@Route(path = NavigationRoutePath.NAVIGATION_PROJECT)
class ProjectActivity : BaseActivity() {

    private val binding: ActivityProjectBinding by binding(R.layout.activity_project)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        window.statusBarColor = Color.TRANSPARENT
        setSupportActionBar(binding.toolbar)
        binding.fabShare.setOnClickListener {
            ShareUtils.shareText(this, getString(R.string.share_download_content, getString(R.string.download_url)))
        }
    }
}