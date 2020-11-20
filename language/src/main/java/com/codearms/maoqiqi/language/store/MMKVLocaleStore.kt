package com.codearms.maoqiqi.language.store

import com.tencent.mmkv.MMKV
import java.util.*


/**
 * 使用MMKV高性能组件保存数据
 * author: March
 * date: 2020-11-20 21:01
 * version v1.0.0
 */
class MMKVLocaleStore : LocaleStore {

    var mmkv = MMKV.mmkvWithID("com.codearms.maoqiqi.language")


    override fun getLocale(): Locale {
        TODO("Not yet implemented")
    }

    override fun setLocale(locale: Locale) {
        TODO("Not yet implemented")
    }

    override fun isFollowingSystemLocale(): Boolean = mmkv.decodeBool(FOLLOW_SYSTEM_LOCALE_KEY, false)

    override fun setFollowSystemLocale(value: Boolean) {
        mmkv.encode(FOLLOW_SYSTEM_LOCALE_KEY, value)
    }

    companion object {
        private const val LANGUAGE_KEY = "language_key"
        private const val FOLLOW_SYSTEM_LOCALE_KEY = "follow_system_locale_key"
    }
}