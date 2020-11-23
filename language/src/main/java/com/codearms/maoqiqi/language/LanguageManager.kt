package com.codearms.maoqiqi.language

import android.app.Application
import android.content.Context
import com.codearms.maoqiqi.language.store.LocaleStore
import com.codearms.maoqiqi.language.store.MMKVLocaleStore
import java.util.*

/**
 * LanguageManager是一种管理应用程序语言环境和语言的工具
 * author: March
 * date: 2020-11-20 21:01
 * version v1.0.0
 */
class LanguageManager private constructor(
    private val store: LocaleStore,
    private val delegate: UpdateLocaleDelegate
) {

    private var systemLocale: Locale = Locale.getDefault()

    @JvmOverloads
    fun setLocale(context: Context, language: String, country: String = "", variant: String = "") {
        setLocale(context, Locale(language, country, variant))
    }

    fun setLocale(context: Context, locale: Locale) {
        store.setFollowSystemLocale(false)
        store.setLocale(locale)
        delegate.applyLocale(context, locale)
    }

    fun getLocale(): Locale = store.getLocale()

    /**
     * 已废弃的ISO语言代码"iw", "ji", 和"in"被分别转换为"he", "yi", 和"id"
     */
    fun getLanguage(): String = verifyLanguage(getLocale().language)

    private fun verifyLanguage(language: String): String = when (language) {
        "iw" -> "he"
        "ji" -> "yi"
        "in" -> "id"
        else -> language
    }

    fun isFollowingSystemLocale() = store.isFollowingSystemLocale()

    fun setFollowSystemLocale(context: Context) {
        store.setFollowSystemLocale(true)
        store.setLocale(systemLocale)
        delegate.applyLocale(context, systemLocale)
    }

    private fun initialize(application: Application) {
        application.registerActivityLifecycleCallbacks(LanguageLifecycleCallbacks { activity ->
            delegate.applyLocale(activity, store.getLocale())
            // activity.resetTitle()
        })
        application.registerComponentCallbacks(LanguageComponentCallbacks { config ->
            systemLocale = config.getLocaleCompat()
            if (store.isFollowingSystemLocale()) {
                store.setLocale(systemLocale)
                delegate.applyLocale(application, systemLocale)
            } else {
                delegate.applyLocale(application, store.getLocale())
            }
        })
        val locale = if (store.isFollowingSystemLocale()) systemLocale else store.getLocale()
        store.setLocale(locale)
        delegate.applyLocale(application, locale)
    }

    companion object {

        private lateinit var instance: LanguageManager

        @JvmStatic
        fun getInstance(): LanguageManager = instance

        /**
         * 该方法必须在任何对[LanguageManager]的调用之前调用,并且只能调用一次.
         */
        @JvmStatic
        fun init(application: Application, store: LocaleStore): LanguageManager {
            val manager = LanguageManager(store, UpdateLocaleDelegate())
            manager.initialize(application)
            instance = manager
            return manager
        }

        /**
         * 使用Application和默认Locale初始化
         */
        @JvmStatic
        @JvmOverloads
        fun init(application: Application, defaultLocale: Locale = Locale.getDefault()): LanguageManager {
            return init(application, MMKVLocaleStore(application, defaultLocale))
        }

        /**
         * 使用Application和Language初始化
         */
        @JvmStatic
        fun init(application: Application, defaultLanguage: String): LanguageManager {
            return init(application, Locale(defaultLanguage))
        }
    }
}