package com.codearms.maoqiqi.one.base

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.codearms.maoqiqi.log.LogLifecycleObserver
import com.codearms.maoqiqi.log.LogUtils

/**
 * Log fragment
 * author: March
 * date: 2021-02-01 21:01
 * version v1.0.0
 */
abstract class AA : Fragment() {

    protected var logInfo: LogUtils.LogInfo? = LogUtils.LogInfo("LogFragment")

    // @deprecated Use {@link FragmentTransaction#setMaxLifecycle(Fragment, Lifecycle.State)} instead.
    @Suppress("DEPRECATION")
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        LogUtils.v(logInfo, "setUserVisibleHint(isVisibleToUser: Boolean),isVisibleToUser=$isVisibleToUser")
    }

    // 该方法只在我们直接用标签在布局中定义的时候才会被调用
    override fun onInflate(context: Context, attrs: AttributeSet, savedInstanceState: Bundle?) {
        super.onInflate(context, attrs, savedInstanceState)
        LogUtils.v(logInfo, "onInflate(context: Context, attrs: AttributeSet, savedInstanceState: Bundle?)")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        LogUtils.v(logInfo, "onAttach(context: Context)")
    }

    override fun onAttachFragment(childFragment: Fragment) {
        super.onAttachFragment(childFragment)
        LogUtils.v(logInfo, "onAttachFragment(childFragment: Fragment),childFragment=${childFragment.javaClass.name}")
    }

    // 系统会在创建片段时调用此方法,只会调用一次。您应该在此初始化您想在片段暂停或停止后恢复时需要的数据。
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtils.v(logInfo, "onCreate(savedInstanceState: Bundle?)")
        lifecycle.addObserver(LogLifecycleObserver())
    }

    // 每次创建,绘制改Fragment的View组件时回调,会将显示的View返回
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        LogUtils.v(logInfo, "onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LogUtils.v(logInfo, "onViewCreated(view: View, savedInstanceState: Bundle?)")
    }

    // 当Fragment所在的Activity启动完成后回调
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        LogUtils.v(logInfo, "onActivityCreated(savedInstanceState: Bundle?)")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        LogUtils.v(logInfo, "onViewStateRestored(savedInstanceState: Bundle?)")
    }

    override fun onStart() {
        super.onStart()
        LogUtils.v(logInfo, "onStart()")
    }

    override fun onResume() {
        super.onResume()
        LogUtils.v(logInfo, "onResume()")
    }

    override fun onPause() {
        super.onPause()
        LogUtils.v(logInfo, "onPause()")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        LogUtils.v(logInfo, "onSaveInstanceState(outState: Bundle)")
    }

    override fun onStop() {
        super.onStop()
        LogUtils.v(logInfo, "onStop()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        LogUtils.v(logInfo, "onDestroyView()")
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtils.v(logInfo, "onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        LogUtils.v(logInfo, "onDetach()")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        LogUtils.v(logInfo, "onConfigurationChanged(newConfig: Configuration)")
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        LogUtils.v(logInfo, "onHiddenChanged(hidden: Boolean),hidden=$hidden")
    }
}