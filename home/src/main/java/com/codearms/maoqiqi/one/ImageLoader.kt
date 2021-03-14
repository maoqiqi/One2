package com.codearms.maoqiqi.one

import android.app.Activity
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

object ImageLoader {

    @JvmStatic
    fun Activity.displayImage(imageView: ImageView, path: String) {
        Glide.with(this).load(path).into(imageView)
    }

    fun Fragment.displayImage(imageView: ImageView, path: String, placeholder: Int = 0) {
        if (placeholder == 0)
            Glide.with(this).load(path).into(imageView)
        else
            Glide.with(this).load(path).placeholder(placeholder).into(imageView)
    }
}