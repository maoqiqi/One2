package com.codearms.maoqiqi.one

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.multidex.MultiDex
import com.codearms.maoqiqi.language.LanguageManager
import com.codearms.maoqiqi.language.store.MMKVLocaleStore
import com.codearms.maoqiqi.log.LogComponentCallbacks
import com.codearms.maoqiqi.log.LogLifecycleCallbacks

class App : Application() {

    private val tag = "App"

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        Log.e(tag, "attachBaseContext(base: Context?)")
        Log.e(tag, "-->configuration:${resources.configuration}")
        Log.e(tag, "-->configuration:${resources.configuration.getLocaleCompat()}")
        MultiDex.install(this)
        registerActivityLifecycleCallbacks(LogLifecycleCallbacks())
        registerComponentCallbacks(LogComponentCallbacks())
        LanguageManager.init(this, MMKVLocaleStore(this))
    }
}