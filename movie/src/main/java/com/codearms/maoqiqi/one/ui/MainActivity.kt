package com.codearms.maoqiqi.one.ui

import android.os.Bundle
import android.util.Log
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.movie.R
import com.codearms.maoqiqi.one.movie.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private val binding: ActivityMainBinding by binding(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        setSupportActionBar(binding.toolbar)

        var params: String? = "aa"
        params = null

        Log.e("info", "==============")
        params?.let { Log.e("info", "null") } ?: Log.e("info", "params=$params")
    }
}