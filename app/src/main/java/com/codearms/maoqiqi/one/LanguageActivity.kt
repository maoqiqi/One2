package com.codearms.maoqiqi.one

import android.content.Intent
import android.os.Bundle
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.databinding.ActivityLanguageBinding

class LanguageActivity : BaseActivity() {

    private val binding: ActivityLanguageBinding by binding(R.layout.activity_language)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btnSetting.setOnClickListener { LocaleManager.setNewLocale(this) }
        binding.btnOpen.setOnClickListener { startActivity(Intent(this, LanguageActivity::class.java)) }
    }
}