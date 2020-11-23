package com.codearms.maoqiqi.language.store

import java.util.*

/**
 * 在内存中保存数据
 * author: March
 * date: 2020-11-20 21:01
 * version v1.0.0
 */
class InMemoryLocaleStore : LocaleStore {

    private var locale: Locale = Locale.getDefault()
    private var isFollowingSystemLocale = true

    override fun getLocale(): Locale = locale

    override fun setLocale(locale: Locale) {
        this.locale = locale
    }

    override fun isFollowingSystemLocale(): Boolean = isFollowingSystemLocale

    override fun setFollowSystemLocale(value: Boolean) {
        this.isFollowingSystemLocale = value
    }
}