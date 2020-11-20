package com.codearms.maoqiqi.language

import android.content.ComponentCallbacks
import android.content.res.Configuration

class LanguageComponentCallbacks(
    private val callBack: (Configuration) -> Unit
) : ComponentCallbacks {

    override fun onConfigurationChanged(newConfig: Configuration) {
        callBack(newConfig)
    }

    override fun onLowMemory() {
        // no-op
    }
}