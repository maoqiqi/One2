package com.codearms.maoqiqi.one.app

import android.content.ComponentCallbacks
import android.content.res.Configuration
import android.util.Log

object ComponentCallbacks : ComponentCallbacks {

    private const val TAG = "ComponentCallbacks"

    override fun onConfigurationChanged(newConfig: Configuration) {
        Log.e(TAG, "onConfigurationChanged(newConfig: Configuration)")
        Log.e(TAG, "configuration:$newConfig")
    }

    override fun onLowMemory() {
        Log.e(TAG, "onLowMemory()")
    }
}