package com.codearms.maoqiqi.one.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = "/movie/main")
class MovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        var params: String? = "aa"
        params = null

        Log.e("info", "==============")
        params?.let { Log.e("info", "null") } ?: Log.e("info", "params=$params")

//        params.Tod
    }
}