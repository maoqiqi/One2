package com.codearms.maoqiqi.one.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.codearms.maoqiqi.one.OneRepository
import com.codearms.maoqiqi.one.base.BaseViewModel
import com.codearms.maoqiqi.one.bean.BannerBean
import com.codearms.maoqiqi.one.bean.CommonBean
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val _banner = MutableLiveData<List<BannerBean>>()
    val banner: LiveData<List<BannerBean>> = _banner

    fun getBanner() {
        viewModelScope.launch {
            OneRepository().getBanner().enqueue(object : Callback<CommonBean<List<BannerBean>>> {
                override fun onResponse(call: Call<CommonBean<List<BannerBean>>>, response: Response<CommonBean<List<BannerBean>>>) {
                    Log.e("mfq", response.body().toString())
                    _banner.postValue(response.body()?.data)
                }

                override fun onFailure(call: Call<CommonBean<List<BannerBean>>>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }
    }
}