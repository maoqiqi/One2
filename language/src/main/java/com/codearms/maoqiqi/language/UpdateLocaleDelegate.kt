package com.codearms.maoqiqi.language

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.LocaleList
import android.util.Log
import androidx.annotation.RequiresApi
import java.util.*

internal class UpdateLocaleDelegate {

    internal fun applyLocale(context: Context, locale: Locale) {
        updateResources(context, locale)
        Log.e("info", "context=$context")
        val appContext = context.applicationContext
        if (appContext != null && appContext !== context) {
            Log.e("info", "appContext=$appContext")
            updateResources(appContext, locale)
        }
    }

    @Suppress("DEPRECATION")
    private fun updateResources(context: Context, locale: Locale) {
        Locale.setDefault(locale)

        val res = context.resources
        val current = res.configuration.getLocaleCompat()

        if (current == locale) return

        val config = Configuration(res.configuration)
        when {
            isAtLeastSdkVersion(Build.VERSION_CODES.N) -> setLocaleForApi24(config, locale)
            isAtLeastSdkVersion(Build.VERSION_CODES.JELLY_BEAN_MR1) -> config.setLocale(locale)
            else -> config.locale = locale
        }
        res.updateConfiguration(config, res.displayMetrics)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun setLocaleForApi24(config: Configuration, locale: Locale) {
        // 将目标语言环境放在列表的前面
        val set = linkedSetOf(locale)

        val defaultLocales = LocaleList.getDefault()
        val all = List<Locale>(defaultLocales.size()) { defaultLocales[it] }
        // 添加用户支持的其他语言
        set.addAll(all)

        config.setLocales(LocaleList(*set.toTypedArray()))
    }
}