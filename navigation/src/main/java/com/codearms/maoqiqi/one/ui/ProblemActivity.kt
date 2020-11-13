package com.codearms.maoqiqi.one.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.navigation.R
import com.codearms.maoqiqi.one.navigation.databinding.ActivityProblemBinding

/**
 * TODO
 * author: March
 * date: 2020-11-01 21:01
 * version v1.0.0
 */
@Route(path = "/navigation/problem")
class ProblemActivity : BaseActivity() {

    private val binding: ActivityProblemBinding by binding(R.layout.activity_problem)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        setSupportActionBar(binding.toolbar)
    }
}