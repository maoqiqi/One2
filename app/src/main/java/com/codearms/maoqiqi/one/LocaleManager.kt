package com.codearms.maoqiqi.one

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import java.util.*

class LocaleManager {

    companion object {
        fun setLocale(context: Context): Context {
            return updateResources(context, getLanguageLocale(15))
        }

        fun setNewLocale(context: Context) {
            updateResources(context, getLanguageLocale(14))
        }

        //    private fun setLanguage() {
//        val resources = application.applicationContext.resources
//        val displayMetrics = resources.displayMetrics
//        val config = resources.configuration
//        val locale = getLanguageLocale(16)
//        Log.e("info", "locale=$locale")
//        config.locale = locale
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            val localeList = LocaleList(locale)
//            LocaleList.setDefault(localeList)
//            config.setLocales(localeList)
//            application.applicationContext.createConfigurationContext(config)
//            Locale.setDefault(locale)
//        }
//        resources.updateConfiguration(config, displayMetrics)
//    }

        private fun updateResources(context: Context, locale: Locale): Context {
            Locale.setDefault(locale)

            val res = context.applicationContext.resources
            val config = Configuration(res.configuration)

            // 做版本兼容性判断
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                config.setLocale(locale)
                // createConfigurationContext 对于API≥17
                context.createConfigurationContext(config)
            } else {
                config.locale = locale
                // updateConfiguration 对于API <17
                res.updateConfiguration(config, res.displayMetrics)
                context
            }
        }

        // 获取系统当前语言
        fun getLocale(context: Context): Locale {
            val config = context.applicationContext.resources.configuration
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) config.locales[0] else config.locale
        }

        private fun getLanguageLocale(position: Int): Locale = when (position) {
//            0 -> application.applicationContext.resources.configuration.locale
            1 -> Locale("ar") // 阿拉伯语
            2 -> Locale.GERMAN // 德语
            3 -> Locale.ENGLISH // 英语
            4 -> Locale("es") // 西班牙语
            5 -> Locale.FRENCH // 法语
            6 -> Locale("hi") // 印地语
            7 -> Locale("in")// 印度尼西亚语
            8 -> Locale.ITALIAN // 意大利语
            9 -> Locale.JAPAN // 日语
            10 -> Locale.KOREAN // 韩语
            11 -> Locale("pt") // 葡萄牙语
            12 -> Locale("ru") // 俄语
            13 -> Locale("th")  // 泰语
            14 -> Locale("tl") // 菲律宾语
            15 -> Locale("vi")  // 越南语
            16 -> Locale.TRADITIONAL_CHINESE // 繁体中文
            else -> Locale.SIMPLIFIED_CHINESE // 简体中文
        }
    }
}