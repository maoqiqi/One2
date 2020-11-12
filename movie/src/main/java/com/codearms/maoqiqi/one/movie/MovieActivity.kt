package com.codearms.maoqiqi.one.movie

import android.os.Bundle
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.codearms.maoqiqi.one.base.BaseActivity
import com.codearms.maoqiqi.one.movie.databinding.ActivityMovieBinding

@Route(path = "/movie/main")
class MovieActivity : BaseActivity() {

    private val binding: ActivityMovieBinding by binding(R.layout.activity_movie)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        setSupportActionBar(binding.toolbar)

        var params: String? = "aa"
        params = null

        Log.e("info", "==============")
        params?.let { Log.e("info", "null") } ?: Log.e("info", "params=$params")

//        params.Tod
    }
}