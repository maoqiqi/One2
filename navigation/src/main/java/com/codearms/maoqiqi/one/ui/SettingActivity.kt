package com.codearms.maoqiqi.one.ui

import android.os.Bundle
import androidx.core.content.ContextCompat
import com.alibaba.android.arouter.facade.annotation.Route
import com.codearms.maoqiqi.databinding.binding
import com.codearms.maoqiqi.one.NavigationRoutePath
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.navigation.R
import com.codearms.maoqiqi.one.navigation.databinding.ActivitySettingBinding

/**
 * 设置
 * link: https://github.com/maoqiqi/one
 * e-mail: fengqi.mao.march@gmail.com
 * author: March
 * date: 2021-03-04 21:01
 * version v1.0.0
 */
@Route(path = NavigationRoutePath.NAVIGATION_SETTING)
class SettingActivity : BaseActivity() {

    private val binding: ActivitySettingBinding by binding(R.layout.activity_setting)
    private val colorMain by lazy { ContextCompat.getColor(this, R.color.color_text_main) }
    private val colorMainSub by lazy { ContextCompat.getColor(this, R.color.color_text_main_sub) }
    private val colorMainSecondary by lazy { ContextCompat.getColor(this, R.color.color_text_secondary) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)
        binding.apply {
            layoutSystemAnimation.setOnClickListener { scSystemAnimation.isChecked = !scSystemAnimation.isChecked }
            layoutLauncherPage.setOnClickListener { setLauncherPageRandomEnable(!scLauncherPage.isChecked) }
            layoutLauncherPageRandom.setOnClickListener { setLauncherPageRandomDesc(!scLauncherPageRandom.isChecked) }
        }
        setLauncherPageRandomEnable(false)
        setLauncherPageRandomDesc(false)
    }

    private fun setLauncherPageRandomEnable(isChecked: Boolean) {
        binding.apply {
            scLauncherPage.isChecked = isChecked
            layoutLauncherPageRandom.isClickable = isChecked
            if (isChecked) {
                tvLauncherPageDesc.setText(R.string.launcher_page_desc_2)
                tvLauncherPageRandomTitle.setTextColor(colorMain)
                tvLauncherPageRandomDesc.setTextColor(colorMainSub)
            } else {
                tvLauncherPageDesc.setText(R.string.launcher_page_desc_1)
                tvLauncherPageRandomTitle.setTextColor(colorMainSecondary)
                tvLauncherPageRandomDesc.setTextColor(colorMainSecondary)
            }
        }
    }

    private fun setLauncherPageRandomDesc(isChecked: Boolean) {
        binding.apply {
            scLauncherPageRandom.isChecked = isChecked
            if (isChecked) {
                tvLauncherPageRandomDesc.setText(R.string.launcher_page_random_desc_2)
            } else {
                tvLauncherPageRandomDesc.setText(R.string.launcher_page_random_desc_1)
            }
        }
    }
}