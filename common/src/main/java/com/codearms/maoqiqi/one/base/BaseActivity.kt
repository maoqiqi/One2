package com.codearms.maoqiqi.one.base

import android.view.MenuItem
import android.view.animation.Animation
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.codearms.maoqiqi.log.LogActivity
import com.codearms.maoqiqi.log.LogUtils

/**
 * AppCompatActivity 基类
 * author: March
 * date: 2020-11-01 21:01
 * version v1.0.0
 */
abstract class BaseActivity : LogActivity() {

    init {
        logInfo = LogUtils.LogInfo(javaClass.simpleName, false, false)
    }

    private var dialog: AlertDialog? = null
    private var iv: ImageView? = null
    private var tv: TextView? = null
    private var tvClose: TextView? = null
    private var anim: Animation? = null

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return super.onOptionsItemSelected(item)
    }
}