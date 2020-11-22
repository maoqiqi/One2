package com.codearms.maoqiqi.one.base

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.codearms.maoqiqi.one.app.LogLifecycleObserver

/**
 * Log fragment
 * author: March
 * date: 2020-11-01 21:01
 * version v1.0.0
 */
abstract class LogFragment : Fragment() {

    open fun getTagName(): String = javaClass.simpleName

    @Suppress("DEPRECATION")
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        Log.e(getTagName(), "-->setUserVisibleHint(isVisibleToUser: Boolean)")
        Log.e(getTagName(), "-->isVisibleToUser:$isVisibleToUser")
    }

    override fun onInflate(context: Context, attrs: AttributeSet, savedInstanceState: Bundle?) {
        super.onInflate(context, attrs, savedInstanceState)
        Log.e(getTagName(), "-->onInflate(context: Context, attrs: AttributeSet, savedInstanceState: Bundle?)")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e(getTagName(), "-->onAttach(context: Context)")
    }

    override fun onAttachFragment(childFragment: Fragment) {
        super.onAttachFragment(childFragment)
        Log.e(getTagName(), "-->onAttachFragment(childFragment: Fragment)")
        Log.e(getTagName(), "-->childFragment:${childFragment.javaClass.name}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(getTagName(), "-->onCreate(savedInstanceState: Bundle?)")
        lifecycle.addObserver(LogLifecycleObserver(getTagName()))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.e(getTagName(), "-->onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(getTagName(), "-->onViewCreated(view: View, savedInstanceState: Bundle?)")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e(getTagName(), "-->onActivityCreated(savedInstanceState: Bundle?)")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.e(getTagName(), "-->onViewStateRestored(savedInstanceState: Bundle?)")
    }

    override fun onStart() {
        super.onStart()
        Log.e(getTagName(), "-->onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.e(getTagName(), "-->onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.e(getTagName(), "-->onPause()")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e(getTagName(), "-->onSaveInstanceState(outState: Bundle)")
    }

    override fun onStop() {
        super.onStop()
        Log.e(getTagName(), "-->onStop()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e(getTagName(), "-->onDestroyView()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(getTagName(), "-->onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e(getTagName(), "-->onDetach()")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.e(getTagName(), "-->onConfigurationChanged(newConfig: Configuration)")
        Log.e(getTagName(), "-->configuration:$newConfig")
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        Log.e(getTagName(), "-->onHiddenChanged(hidden: Boolean) = $hidden")
    }
}