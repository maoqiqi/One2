package com.codearms.maoqiqi.one.ui

import android.graphics.Paint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.codearms.maoqiqi.android.AppUtils.getAppVersionName
import com.codearms.maoqiqi.android.IntentUtils.startActivity
import com.codearms.maoqiqi.databinding.binding
import com.codearms.maoqiqi.one.NavigationRoutePath
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.navigation.R
import com.codearms.maoqiqi.one.navigation.databinding.ActivityAboutBinding

/**
 * 关于我们
 * link: https://github.com/maoqiqi/one
 * e-mail: fengqi.mao.march@gmail.com
 * author: March
 * date: 2021-03-04 21:01
 * version v1.0.0
 */
@Route(path = NavigationRoutePath.NAVIGATION_ABOUT)
class AboutActivity : BaseActivity(), View.OnClickListener {

    private val binding: ActivityAboutBinding by binding(R.layout.activity_about)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)

        binding.tvVersion.text = getString(R.string.current_version, getAppVersionName())

        binding.btnProject.setOnClickListener(this)
        binding.btnProject.setOnClickListener(this)
        binding.btnUpdate.setOnClickListener(this)
        binding.btnStar.setOnClickListener(this)
//        tvGank.setOnClickListener(this)
//        tvDouBan.setOnClickListener(this)
    }

    private fun setUnderLine(textView: TextView) {
        textView.paint.flags = Paint.UNDERLINE_TEXT_FLAG
        textView.paint.isAntiAlias = true
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_project -> startActivity(ProjectActivity::class.java)
//            R.id.tvCheckUpdate -> WebViewActivity.start(activity, R.color.color_navigation, "", getString(R.string.project_url))
            R.id.btn_update -> startActivity(UpdateActivity::class.java)
//            R.id.tvStar -> WebViewActivity.start(activity, R.color.color_navigation, "", getString(R.string.project_url))
//            R.id.tvGank -> WebViewActivity.start(activity, R.color.color_navigation, "", getString(R.string.gank_api))
//            R.id.tvDouBan -> WebViewActivity.start(activity, R.color.color_navigation, "", getString(R.string.dou_ban_terms))
        }
    }
}