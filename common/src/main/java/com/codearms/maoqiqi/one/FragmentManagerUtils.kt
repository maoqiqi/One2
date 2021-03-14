package com.codearms.maoqiqi.one

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

object FragmentManagerUtils {

    @JvmOverloads
    @JvmStatic
    fun FragmentActivity.addFragment(container: Int, newFragment: Fragment?, tag: String? = null, savedInstanceState: Bundle? = null) {
        val fragment = if (savedInstanceState == null) newFragment else supportFragmentManager.findFragmentByTag(tag)
        val ft = supportFragmentManager.beginTransaction()
        fragment?.let { if (it.isAdded) ft.show(it).commit() else ft.add(container, it, tag).commit() }
    }

    fun Fragment.addFragment(container: Int, newFragment: Fragment?, tag: String? = null, savedInstanceState: Bundle? = null) {
        val fragment = if (savedInstanceState == null) newFragment else childFragmentManager.findFragmentByTag(tag)
        val ft = childFragmentManager.beginTransaction()
        fragment?.let { if (it.isAdded) ft.show(it).commit() else ft.add(container, it, tag).commit() }
    }

    @JvmOverloads
    @JvmStatic
    fun FragmentActivity.switchFragment(container: Int, from: Fragment?, to: Fragment?, tag: String? = null): Fragment? {
        if (to != null && from !== to) { // from != to 才切换
            val ft = supportFragmentManager.beginTransaction()
            // from 不为 null,隐藏
            from?.let { ft.hide(it) }
            // 显示 to
            to.let { if (it.isAdded) ft.show(it).commit() else ft.add(container, it, tag).commit() }
            return to
        }
        return from
    }
}