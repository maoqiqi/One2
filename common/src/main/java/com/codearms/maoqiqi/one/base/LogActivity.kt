package com.codearms.maoqiqi.one.base

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.codearms.maoqiqi.one.app.LogLifecycleObserver
import com.codearms.maoqiqi.one.getLocaleCompat

/**
 * Log activity
 * author: March
 * date: 2020-11-01 21:01
 * version v1.0.0
 */
abstract class LogActivity : AppCompatActivity() {

    open fun getTagName(): String = javaClass.simpleName

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        Log.e(getTagName(), "-->attachBaseContext(newBase: Context?)")
    }

    // The activity is being created.
    // 您应该在此方法中执行所有正常的静态设置—创建视图、将数据绑定到列表等等.始终后接onStart().
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(getTagName(), "-->onCreate(savedInstanceState: Bundle?)")
        Log.e(getTagName(), "-->configuration:${resources.configuration}")
        Log.e(getTagName(), "-->configuration:${resources.configuration.getLocaleCompat()}")
        lifecycle.addObserver(LogLifecycleObserver(getTagName()))
    }

    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)
        Log.e(getTagName(), "-->onAttachFragment(fragment: Fragment)")
        Log.e(getTagName(), "-->fragment:${fragment.javaClass.name}")
    }

    // 在Activity已停止并即将再次启动前调用.始终后接onStart().
    override fun onRestart() {
        super.onRestart()
        Log.e(getTagName(), "-->onRestart()")
    }

    // The activity is about to become visible.
    // 如果Activity转入前台,则后接onResume(),如果Activity转入隐藏状态,则后接onStop().
    override fun onStart() {
        super.onStart()
        Log.e(getTagName(), "-->onStart()")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        // 您应始终调用onRestoreInstanceState()的父类实现,以便默认实现可以恢复视图层次结构的状态。
        super.onRestoreInstanceState(savedInstanceState)
        Log.e(getTagName(), "-->onRestoreInstanceState(savedInstanceState: Bundle)")
    }

    // The activity has become visible (it is now "resumed").
    // 此时,Activity处于Activity堆栈的顶层,并具有用户输入焦点.始终后接onPause().
    override fun onResume() {
        super.onResume()
        Log.e(getTagName(), "-->onResume()")
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.e(getTagName(), "-->onAttachedToWindow()")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        Log.e(getTagName(), "-->onCreateOptionsMenu(menu: Menu)")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        Log.e(getTagName(), "-->onPrepareOptionsMenu(menu: Menu)")
        return super.onPrepareOptionsMenu(menu)
    }

    // Another activity is taking focus (this activity is about to be "paused").
    // 此方法通常用于确认对持久性数据的未保存更改、停止动画以及其他可能消耗CPU的内容.
    // 它应该非常迅速地执行所需操作,因为它返回后,下一个Activity才能继续执行.
    override fun onPause() {
        super.onPause()
        Log.e(getTagName(), "-->onPause()")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        // 始终调用超类,以便它可以保存视图层次结构状态
        super.onSaveInstanceState(outState)
        Log.e(getTagName(), "-->onSaveInstanceState(outState: Bundle)")
    }

    // The activity is no longer visible (it is now "stopped")
    // 如果Activity被销毁,或另一个Activity(一个现有Activity或新Activity)继续执行并将其覆盖,就可能发生这种情况.
    // 如果Activity恢复与用户的交互,则后接onRestart(),如果Activity被销毁,则后接onDestroy().
    override fun onStop() {
        super.onStop()
        Log.e(getTagName(), "-->onStop()")
    }

    // The activity is about to be destroyed.
    // 当Activity结束(有人对Activity调用了finish()),或系统为节省空间而暂时销毁该Activity 实例时,可能会调用它.
    // 您可以通过isFinishing()方法区分这两种情形.
    override fun onDestroy() {
        super.onDestroy()
        Log.e(getTagName(), "-->onDestroy()")
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        Log.e(getTagName(), "-->onDetachedFromWindow()")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.e(getTagName(), "-->onConfigurationChanged(newConfig: Configuration)")
        Log.e(getTagName(), "-->configuration:$newConfig")
    }
}