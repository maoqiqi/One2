package com.codearms.maoqiqi.language.store

import java.util.*

interface LocaleStore {

    fun getLocale(): Locale
    fun setLocale(locale: Locale)

    fun isFollowingSystemLocale(): Boolean
    fun setFollowSystemLocale(value: Boolean)
}