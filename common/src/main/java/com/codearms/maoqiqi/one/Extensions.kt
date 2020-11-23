package com.codearms.maoqiqi.one

import android.content.res.Configuration
import android.os.Build
import java.util.*

fun Configuration.getLocaleCompat(): Locale {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) locales.get(0) else locale
}