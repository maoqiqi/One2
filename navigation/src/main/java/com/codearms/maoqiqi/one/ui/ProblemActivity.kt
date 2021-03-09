package com.codearms.maoqiqi.one.ui

import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.codearms.maoqiqi.databinding.binding
import com.codearms.maoqiqi.one.NavigationRoutePath
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.navigation.R
import com.codearms.maoqiqi.one.navigation.databinding.ActivityProblemBinding

/**
 * 问题反馈
 * link: https://github.com/maoqiqi/one
 * e-mail: fengqi.mao.march@gmail.com
 * author: March
 * date: 2021-03-04 21:01
 * version v1.0.0
 */
@Route(path = NavigationRoutePath.NAVIGATION_PROBLEM)
class ProblemActivity : BaseActivity(), View.OnClickListener {

    private val binding: ActivityProblemBinding by binding(R.layout.activity_problem)
    private val qqUrl = "mqqwpa://im/chat?chat_type=wpa&uin=1335354725"
    private val emailUrl = "mailto:fengqi.mao.march@gmail.com"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)
        binding.tvIssues.setOnClickListener(this)
        binding.tvFaq.setOnClickListener(this)
        binding.tvQq.setOnClickListener(this)
        binding.tvEmail.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
//            R.id.tv_issues -> WebViewActivity.start(this, R.color.color_navigation, getString(R.string.issues_name), getString(R.string.issues_url))
//            R.id.tv_faq -> WebViewActivity.start(this, R.color.color_navigation, getString(R.string.faq_name), getString(R.string.faq_url))
//            R.id.tv_qq -> activity.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(qqUrl)))
//            R.id.tv_email -> startActivity(Intent(Intent.ACTION_SENDTO, Uri.parse(emailUrl)))
        }
    }
}