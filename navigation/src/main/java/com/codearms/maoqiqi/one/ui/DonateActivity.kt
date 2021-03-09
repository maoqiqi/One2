package com.codearms.maoqiqi.one.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.codearms.maoqiqi.databinding.binding
import com.codearms.maoqiqi.one.NavigationRoutePath
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.navigation.R
import com.codearms.maoqiqi.one.navigation.databinding.ActivityDonateBinding
import com.flyco.tablayout.listener.OnTabSelectListener

/**
 * 捐赠开发者
 * link: https://github.com/maoqiqi/one
 * e-mail: fengqi.mao.march@gmail.com
 * author: March
 * date: 2021-03-04 21:01
 * version v1.0.0
 */
@Route(path = NavigationRoutePath.NAVIGATION_DONATE)
class DonateActivity : BaseActivity() {

    private val binding: ActivityDonateBinding by binding(R.layout.activity_donate)
    private val titles by lazy { arrayOf(getString(R.string.ali_pay), getString(R.string.wx_pay)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)
        binding.tabLayout.setTabData(titles)
        binding.tabLayout.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                binding.ivPay.setImageResource(if (position == 0) R.drawable.ic_ali_pay else R.drawable.ic_wx_pay)
            }

            override fun onTabReselect(position: Int) {}
        })
    }
}