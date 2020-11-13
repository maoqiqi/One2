package com.codearms.maoqiqi.one.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.navigation.R
import com.codearms.maoqiqi.one.navigation.databinding.ActivityScanCodeBinding

/**
 * TODO
 * author: March
 * date: 2020-11-01 21:01
 * version v1.0.0
 */
@Route(path = "/navigation/scan_code")
class ScanCodeActivity : BaseActivity() {

    private val binding: ActivityScanCodeBinding by binding(R.layout.activity_scan_code)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        setSupportActionBar(binding.toolbar)
    }
}