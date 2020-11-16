package com.codearms.maoqiqi.one.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.codearms.maoqiqi.one.app.LogLifecycleObserver

/**
 * Log fragment
 * author: March
 * date: 2020-11-01 21:01
 * version v1.0.0
 */
abstract class LogFragment : Fragment() {

    private val tagName = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(LogLifecycleObserver(tagName))
    }
}