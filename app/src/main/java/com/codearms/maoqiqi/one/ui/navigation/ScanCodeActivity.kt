package com.codearms.maoqiqi.one.ui.navigation

import android.os.Bundle
import com.codearms.maoqiqi.one.R
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.databinding.ActivityScanCodeBinding

class ScanCodeActivity : BaseActivity() {

    private val binding: ActivityScanCodeBinding by binding(R.layout.activity_scan_code)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        binding.text.text = "ProjectFragment"
    }
}