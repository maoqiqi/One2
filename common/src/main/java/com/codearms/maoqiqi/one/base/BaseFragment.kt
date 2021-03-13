package com.codearms.maoqiqi.one.base

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.codearms.maoqiqi.log.LogFragment
import com.codearms.maoqiqi.log.LogUtils

/**
 * Fragment 基类
 * author: March
 * date: 2020-11-01 21:01
 * version v1.0.0
 */
abstract class BaseFragment : LogFragment() {

    init {
        logInfo = LogUtils.LogInfo(javaClass.simpleName, true, false)
    }

    protected var isShow = false

    override fun onResume() {
        super.onResume()
        isShow = true
        LogUtils.v(logInfo, "onResume:isShow:$isShow")
    }

    override fun onPause() {
        super.onPause()
        isShow = false
        LogUtils.v(logInfo, "onPause:isShow:$isShow")
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        LogUtils.v(logInfo, "onCreateOptionsMenu(menu: Menu, inflater: MenuInflater)")
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        LogUtils.v(logInfo, "onPrepareOptionsMenu(menu: Menu)")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        LogUtils.v(logInfo, "onOptionsItemSelected(item: MenuItem): Boolean")
        return super.onOptionsItemSelected(item)
    }

    override fun onOptionsMenuClosed(menu: Menu) {
        super.onOptionsMenuClosed(menu)
        LogUtils.v(logInfo, "onOptionsMenuClosed(menu: Menu)")
    }

    override fun onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu()
        LogUtils.v(logInfo, "onDestroyOptionsMenu()")
    }
}