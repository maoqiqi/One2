package com.codearms.maoqiqi.one.base

import android.view.animation.Animation
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * AppCompatActivity 基类
 * author: March
 * date: 2020/10/16 14:31
 * version v1.0.0
 */
abstract class BaseActivity : AppCompatActivity() {

    private var dialog: AlertDialog? = null
    private var iv: ImageView? = null
    private var tv: TextView? = null
    private var tvClose: TextView? = null
    private var anim: Animation? = null

    protected fun <T : ViewDataBinding> binding(@LayoutRes resId: Int): Lazy<T> = lazy {
        DataBindingUtil.setContentView(this, resId)
    }
}