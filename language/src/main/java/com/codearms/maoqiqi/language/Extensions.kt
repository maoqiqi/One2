package com.codearms.maoqiqi.language

import android.app.Activity
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.os.Build
import java.util.*

fun isAtLeastSdkVersion(versionCode: Int): Boolean {
    return Build.VERSION.SDK_INT >= versionCode
}

@Suppress("DEPRECATION")
fun Configuration.getLocaleCompat(): Locale =
    if (isAtLeastSdkVersion(Build.VERSION_CODES.N)) locales.get(0) else locale

fun Activity.resetTitle() {
    try {
        val info = packageManager.getActivityInfo(componentName, PackageManager.GET_META_DATA)
        if (info.labelRes != 0) setTitle(info.labelRes)
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
    }
}