package com.codearms.maoqiqi.one.base

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.codearms.maoqiqi.one.app.LogLifecycleObserver

/**
 * Log activity
 * author: March
 * date: 2020-11-01 21:01
 * version v1.0.0
 */
abstract class LogActivity : AppCompatActivity() {

    private val tag = javaClass.simpleName

    private val number: Int = 1

    // The activity is being created.
    // 您应该在此方法中执行所有正常的静态设置—创建视图、将数据绑定到列表等等.始终后接onStart().
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(tag + number, "-->onCreate(@Nullable Bundle savedInstanceState)")
        Log.e("configuration", resources.configuration.toString())
        lifecycle.addObserver(LogLifecycleObserver())
    }

    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)
        Log.e(tag + number, "-->onAttachFragment(Fragment fragment) = " + fragment.javaClass.name)
    }

    // 在Activity已停止并即将再次启动前调用.始终后接onStart().
    override fun onRestart() {
        super.onRestart()
        Log.e(tag + number, "-->onRestart()")
    }

    // The activity is about to become visible.
    // 如果Activity转入前台,则后接onResume(),如果Activity转入隐藏状态,则后接onStop().
    override fun onStart() {
        super.onStart()
        Log.e(tag + number, "-->onStart()")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.e(tag + number, "-->onRestoreInstanceState(Bundle savedInstanceState)")
    }

    // The activity has become visible (it is now "resumed").
    // 此时,Activity处于Activity堆栈的顶层,并具有用户输入焦点.始终后接onPause().
    override fun onResume() {
        super.onResume()
        Log.e(tag + number, "-->onResume()")
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.e(tag + number, "-->onAttachedToWindow()")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        Log.e(tag + number, "-->onCreateOptionsMenu(Menu menu)")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        Log.e(tag + number, "-->onPrepareOptionsMenu(Menu menu)")
        return super.onPrepareOptionsMenu(menu)
    }

    // Another activity is taking focus (this activity is about to be "paused").
    // 此方法通常用于确认对持久性数据的未保存更改、停止动画以及其他可能消耗CPU的内容.
    // 它应该非常迅速地执行所需操作,因为它返回后,下一个Activity才能继续执行.
    override fun onPause() {
        super.onPause()
        Log.e(tag + number, "-->onPause()")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e(tag + number, "-->onSaveInstanceState(Bundle outState)")
    }

    // The activity is no longer visible (it is now "stopped")
    // 如果Activity被销毁,或另一个Activity(一个现有Activity或新Activity)继续执行并将其覆盖,就可能发生这种情况.
    // 如果Activity恢复与用户的交互,则后接onRestart(),如果Activity被销毁,则后接onDestroy().
    override fun onStop() {
        super.onStop()
        Log.e(tag + number, "-->onStop()")
    }

    // The activity is about to be destroyed.
    // 当Activity结束(有人对Activity调用了finish()),或系统为节省空间而暂时销毁该Activity 实例时,可能会调用它.
    // 您可以通过isFinishing()方法区分这两种情形.
    override fun onDestroy() {
        super.onDestroy()
        Log.e(tag + number, "-->onDestroy()")
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        Log.e(tag + number, "-->onDetachedFromWindow()")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.e(tag + number, "-->onConfigurationChanged(Configuration newConfig)")
        Log.e("configuration", newConfig.toString())
    }
}