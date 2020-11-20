//package com.codearms.maoqiqi.one
//
//import android.content.Context
//import android.content.res.Configuration
//import android.content.res.Resources
//import android.os.Build
//import android.os.LocaleList
//import java.util.*
//
//
//class LanguageContextWrapper {
//
//    companion object {
//        fun wrap(context: Context, locale: Locale) {
//            Locale.setDefault(locale)
//
//            val res: Resources = context.resources
//            val config = Configuration(res.configuration)
//            if (Build.VERSION.SDK_INT >= 17) {
//                config.setLocale(locale)
//                return context.createConfigurationContext(config)
//            } else {
//                config.locale = locale
//                res.updateConfiguration(config, res.displayMetrics)
//            }
//        }
//    }
//
//    private fun updateResources(context: Context, locale: Locale): Context {
//        Locale.setDefault(locale)
//
//        val res: Resources = context.resources
//        val config = Configuration(res.configuration)
//        if (Build.VERSION.SDK_INT >= 17) {
//            config.setLocale(locale)
//            return context.createConfigurationContext(config)
//        } else {
//            config.locale = locale
//            res.updateConfiguration(config, res.displayMetrics)
//        }
//        return context
//    }
//
//    private fun updateResources(context: Context, language: String): Context? {
//        var context = context
//        val locale = Locale(language)
//        Locale.setDefault(locale)
//        val res = context.resources
//        val config = Configuration(res.configuration)
//        //做版本兼容性判断
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
//            config.setLocale(locale)
//            context = context.createConfigurationContext(config)
//        } else {
//            config.locale = locale
//            //点进去看方法详情
//            res.updateConfiguration(config, res.displayMetrics)
//        }
//        return context
//    }
//
//    fun getLocale(res: Resources): Locale? {
//        val config = res.configuration
//        return if (Build.VERSION.SDK_INT >= 24) config.locales[0] else config.locale
//    }
//
//    fun saveSystemCurrentLanguage(context: Context?) {
//        val locale: Locale
//        locale = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            LocaleList.getDefault()[0]
//        } else {
//            Locale.getDefault()
//        }
//        Log.d(TAG, locale.language)
//        Log.d(TAG, locale.country)
//        LocalSPUtil.getInstance(context).setSystemCurrentLocal(locale)
//    }
//
//    fun wrapContext(context: Context): Context? {
//        val resources = context.resources
//        val locale: Locale = LanguageUtils.getSetLocale()
//        val configuration = resources.configuration
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            configuration.setLocale(locale)
//            val localeList = LocaleList(locale)
//            LocaleList.setDefault(localeList)
//            configuration.setLocales(localeList)
//        } else {
//            configuration.setLocale(locale)
//        }
//        return context.createConfigurationContext(configuration)
//    }
//
//    fun applyChange(context: Context) {
//        val res = context.resources
//        val dm = res.displayMetrics
//        val conf = res.configuration
//        val locale: Locale = getSetLocale()
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            conf.setLocale(locale)
//            val localeList = LocaleList(locale)
//            LocaleList.setDefault(localeList)
//            conf.setLocales(localeList)
//        } else {
//            conf.setLocale(locale)
//        }
//        res.updateConfiguration(conf, dm)
//    }
//}