package com.codearms.maoqiqi.one.app

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * 生命周期观察者
 * author: March
 * date: 2020-11-01 21:01
 * version v1.0.0
 */
class LogLifecycleObserver(private val tag: String = "LogLifecycleObserver") : LifecycleObserver {

    // 每次回调都会调用onAny
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny() {
        Log.e(tag, "onAny:")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.e(tag, "onCreate:")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.e(tag, "onStart:")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.e(tag, "onResume:")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.e(tag, "onPause:")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.e(tag, "onStop:")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.e(tag, "onDestroy:")
    }
}