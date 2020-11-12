package com.codearms.maoqiqi.one.base

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 * Fragment 基类
 * author: March
 * date: 2020-11-01 21:01
 * version v1.0.0
 */
abstract class BaseFragment : Fragment() {

    protected fun <T : ViewDataBinding> binding(): Lazy<T> = lazy {
        DataBindingUtil.bind<T>(requireView())
            ?: throw IllegalStateException("Fragment $this binding is fail or this was called before onCreateView().")
    }
}