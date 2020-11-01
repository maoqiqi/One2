package com.codearms.maoqiqi.one.ui.navigation

import android.graphics.Color
import android.os.Bundle
import com.codearms.maoqiqi.one.R
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.databinding.ActivityProjectBinding
import com.codearms.maoqiqi.one.utils.ShareUtils

/**
 * TODO
 * author: March
 * date: 2020-11-01 21:01
 * version v1.0.0
 */
class ProjectActivity : BaseActivity() {

    private val binding: ActivityProjectBinding by binding(R.layout.activity_project)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = Color.TRANSPARENT
        binding.lifecycleOwner = this
        setSupportActionBar(binding.toolbar)
        binding.fabShare.setOnClickListener {
            ShareUtils.shareText(this, getString(R.string.share_download_content, getString(R.string.download_url)))
        }
    }
}