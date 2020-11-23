package com.codearms.maoqiqi.one

import android.content.Intent
import android.os.Bundle
import com.codearms.maoqiqi.language.LanguageManager
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.databinding.ActivityLanguageBinding
import java.util.*

class LanguageActivity : BaseActivity() {

    private val binding: ActivityLanguageBinding by binding(R.layout.activity_language)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)
        binding.btnSetting.setOnClickListener {
            LanguageManager.getInstance().setLocale(this, getLanguageLocale(1))
            recreate()
        }
        binding.btnAuto.setOnClickListener {
            LanguageManager.getInstance().setFollowSystemLocale(this)
            recreate()
        }
        binding.btnOpen.setOnClickListener { startActivity(Intent(this, LanguageActivity::class.java)) }
    }

    private fun getLanguageLocale(position: Int): Locale = when (position) {
        0 -> Locale.getDefault()
        1 -> Locale("ar") // 阿拉伯语
        2 -> Locale.GERMAN // 德语
        3 -> Locale.ENGLISH // 英语
        4 -> Locale("es") // 西班牙语
        5 -> Locale.FRENCH // 法语
        6 -> Locale("hi") // 印地语
        7 -> Locale("in")// 印度尼西亚语
        8 -> Locale.ITALIAN // 意大利语
        9 -> Locale.JAPAN // 日语
        10 -> Locale.KOREAN // 韩语
        11 -> Locale("pt") // 葡萄牙语
        12 -> Locale("ru") // 俄语
        13 -> Locale("th")  // 泰语
        14 -> Locale("tl") // 菲律宾语
        15 -> Locale("vi")  // 越南语
        16 -> Locale.TRADITIONAL_CHINESE // 繁体中文
        else -> Locale.SIMPLIFIED_CHINESE // 简体中文
    }
}