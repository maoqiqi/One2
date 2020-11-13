package com.codearms.maoqiqi.one

import android.util.Log
//import com.squareup.moshi.JsonAdapter
//import com.squareup.moshi.Moshi

object CommonConflict {

    data class Bean(val name: String)

    const val A = "common"

    fun a() {
//        val moshi = Moshi.Builder().build()
//        val jsonAdapter: JsonAdapter<Bean> = moshi.adapter(Bean::class.java)
//        val bean: Bean? = jsonAdapter.fromJson("{\"name\":\"name\"}")
//        println(bean)
        Log.e("info", "aa")
    }
}