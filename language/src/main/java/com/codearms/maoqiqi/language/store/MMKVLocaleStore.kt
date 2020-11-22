package com.codearms.maoqiqi.language.store

import android.app.Application
import com.tencent.mmkv.MMKV
import java.util.*

/**
 * 使用MMKV高性能组件保存数据
 * author: March
 * date: 2020-11-20 21:01
 * version v1.0.0
 */
class MMKVLocaleStore(
    private val application: Application,
    private val defaultLocale: Locale = Locale.getDefault()
) : LocaleStore {

    private val mmkv by lazy {
        MMKV.initialize(application)
        MMKV.defaultMMKV()
    }

    override fun getLocale(): Locale =
        if (mmkv.decodeString(Locale_LANGUAGE_KEY) != null)
            Locale(
                mmkv.decodeString(Locale_LANGUAGE_KEY, ""),
                mmkv.decodeString(Locale_COUNTRY_KEY, ""),
                mmkv.decodeString(Locale_VARIANT_KEY, "")
            )
        else defaultLocale

    override fun setLocale(locale: Locale) {
        mmkv.apply {
            encode(Locale_LANGUAGE_KEY, locale.language)
            encode(Locale_COUNTRY_KEY, locale.country)
            encode(Locale_VARIANT_KEY, locale.variant)
        }
    }

    override fun isFollowingSystemLocale(): Boolean = mmkv.decodeBool(FOLLOW_SYSTEM_LOCALE_KEY, false)

    override fun setFollowSystemLocale(value: Boolean) {
        mmkv.encode(FOLLOW_SYSTEM_LOCALE_KEY, value)
    }

    companion object {
        private const val Locale_LANGUAGE_KEY = "language"
        private const val Locale_COUNTRY_KEY = "country"
        private const val Locale_VARIANT_KEY = "variant"
        private const val FOLLOW_SYSTEM_LOCALE_KEY = "follow_system_locale_key"
    }
}