package com.codearms.maoqiqi.one.app

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import java.lang.ref.WeakReference

/**
 * 监控应用生命周期
 * author: March
 * date: 2020-11-01 21:01
 * version v1.0.0
 */
object LifecycleCallbacks : Application.ActivityLifecycleCallbacks {

    /**
     * 保存当前显示的Activity
     */
    private var currentActivityRef: WeakReference<Activity>? = null

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        Log.e(activity.javaClass.simpleName, "onActivityCreated(activity: Activity, savedInstanceState: Bundle?)")
    }

    override fun onActivityStarted(activity: Activity) {
        Log.e(activity.javaClass.simpleName, "onActivityStarted(activity: Activity)")
    }

    override fun onActivityResumed(activity: Activity) {
        currentActivityRef = WeakReference(activity)
    }

    override fun onActivityPaused(activity: Activity) {
        Log.e(activity.javaClass.simpleName, "onActivityResumed(activity: Activity)")
    }

    override fun onActivityStopped(activity: Activity) {
        Log.e(activity.javaClass.simpleName, "onActivityStopped(activity: Activity)")
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        Log.e(activity.javaClass.simpleName, "onActivitySaveInstanceState(activity: Activity, outState: Bundle)")
    }

    override fun onActivityDestroyed(activity: Activity) {
        Log.e(activity.javaClass.simpleName, "onActivityDestroyed(activity: Activity)")
    }
}