package com.codearms.maoqiqi.one

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.os.LocaleList
import android.util.Log
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.databinding.ActivityLanguageBinding
import java.util.*

class LanguageActivity : BaseActivity() {

    private val binding: ActivityLanguageBinding by binding(R.layout.activity_language)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btnSetting.setOnClickListener { LocaleManager.setNewLocale(this) }
        binding.btnOpen.setOnClickListener { startActivity(Intent(this, LanguageActivity::class.java)) }
        Log.e("info", "getLocale=${LocaleManager.getLocale(this)}")
    }

    override fun attachBaseContext(newBase: Context?) {
        newBase?.let { super.attachBaseContext(LocaleManager.setLocale(newBase)) } ?: super.attachBaseContext(newBase)
    }
}