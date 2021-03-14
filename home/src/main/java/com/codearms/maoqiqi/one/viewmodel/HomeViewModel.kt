package com.codearms.maoqiqi.one.viewmodel

import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.codearms.maoqiqi.log.LogUtils
import com.codearms.maoqiqi.one.OneRepository
import com.codearms.maoqiqi.one.base.BaseViewModel
import com.codearms.maoqiqi.one.bean.BannerBean

class HomeViewModel : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val _banner = MutableLiveData<List<BannerBean>>()
    val banner: LiveData<List<BannerBean>> = _banner

    fun getBanner() {
        LogUtils.e("====" + (Looper.getMainLooper().thread == Thread.currentThread()))
        request({ OneRepository().getBanner() }) {
            LogUtils.e("====" + (Looper.getMainLooper().thread == Thread.currentThread()))
            LogUtils.e(it.toString())
            _banner.value = it
        }
    }
}