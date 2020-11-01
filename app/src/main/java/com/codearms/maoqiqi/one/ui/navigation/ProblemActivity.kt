package com.codearms.maoqiqi.one.ui.navigation

import android.os.Bundle
import com.codearms.maoqiqi.one.R
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.databinding.ActivityProblemBinding

/**
 * TODO
 * author: March
 * date: 2020-11-01 21:01
 * version v1.0.0
 */
class ProblemActivity : BaseActivity() {

    private val binding: ActivityProblemBinding by binding(R.layout.activity_problem)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        setSupportActionBar(binding.toolbar)
    }
}