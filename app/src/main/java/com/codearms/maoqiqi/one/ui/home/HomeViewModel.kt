package com.codearms.maoqiqi.one.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.codearms.maoqiqi.one.base.BaseViewModel

/**
 * TODO
 * author: March
 * date: 2020-10-16 15:18
 * version v1.3.0
 */
class HomeViewModel : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}