package com.codearms.maoqiqi.one

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import androidx.multidex.MultiDex

class App : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }
}