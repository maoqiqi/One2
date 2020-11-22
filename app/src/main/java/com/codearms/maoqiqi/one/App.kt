package com.codearms.maoqiqi.one

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import android.util.Log
import androidx.multidex.MultiDex
import com.codearms.maoqiqi.language.LanguageManager
import com.codearms.maoqiqi.language.store.MMKVLocaleStore
import com.codearms.maoqiqi.one.app.ComponentCallbacks
import com.codearms.maoqiqi.one.app.LifecycleCallbacks

class App : Application() {

    private val tag = "App"

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        Log.e(tag, "attachBaseContext(base: Context?)")
        MultiDex.install(this)
        registerActivityLifecycleCallbacks(LifecycleCallbacks)
        registerComponentCallbacks(ComponentCallbacks)
        LanguageManager.init(this, MMKVLocaleStore(this))
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.e(tag, "onConfigurationChanged(newConfig: Configuration)")
        Log.e(tag, "configuration:$newConfig")
    }
}