package com.codearms.maoqiqi.one.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.navigation.R
import com.codearms.maoqiqi.one.navigation.databinding.ActivityUpdateBinding

/**
 * TODO
 * author: March
 * date: 2020-11-01 21:01
 * version v1.0.0
 */
@Route(path = "/navigation/update")
class UpdateActivity : BaseActivity() {

    private val binding: ActivityUpdateBinding by binding(R.layout.activity_update)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        setSupportActionBar(binding.toolbar)
    }
}