package com.codearms.maoqiqi.one

import android.content.Context
import android.content.res.ColorStateList
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

object ColorStateListUtils {

    @JvmStatic
    fun createColorStateList(@ColorInt checked: Int, @ColorInt normal: Int): ColorStateList {
        val colors = intArrayOf(checked, normal)
        val states = arrayOfNulls<IntArray>(2)
        states[0] = intArrayOf(android.R.attr.state_checked)
        states[1] = intArrayOf()
        return ColorStateList(states, colors)
    }

    @JvmStatic
    fun Context.createColorStateList(@ColorRes checked: Int, @ColorRes normal: Int): ColorStateList {
        val colors = intArrayOf(ContextCompat.getColor(this, checked), ContextCompat.getColor(this, normal))
        val states = arrayOfNulls<IntArray>(2)
        states[0] = intArrayOf(android.R.attr.state_checked)
        states[1] = intArrayOf()
        return ColorStateList(states, colors)
    }
}