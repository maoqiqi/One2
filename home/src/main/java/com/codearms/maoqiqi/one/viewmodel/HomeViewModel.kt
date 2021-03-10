package com.codearms.maoqiqi.one.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.codearms.maoqiqi.one.OneRepository
import com.codearms.maoqiqi.one.base.BaseViewModel
import kotlinx.coroutines.launch

class HomeViewModel : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun getBanner() {
        viewModelScope.launch { OneRepository().getBanner() }
    }
}