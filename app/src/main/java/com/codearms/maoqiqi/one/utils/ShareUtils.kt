package com.codearms.maoqiqi.one.utils

import android.content.Context
import android.content.Intent
import android.net.Uri

object ShareUtils {

    fun shareText(context: Context, stringRes: Int) {
        shareText(context, context.getString(stringRes))
    }

    /**
     * 使用系统发送分享数据
     */
    fun shareText(context: Context, extraText: String?) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, "分享")
        intent.putExtra(Intent.EXTRA_TEXT, extraText)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(Intent.createChooser(intent, "分享"))
    }

    fun shareImage(context: Context, uri: Uri?, title: String?) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_STREAM, uri)
        intent.type = "image/jpeg"
        context.startActivity(Intent.createChooser(intent, title))
    }
}