package com.codearms.maoqiqi.one.base

import android.os.Looper
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codearms.maoqiqi.log.LogUtils
import com.codearms.maoqiqi.one.bean.CommonBean
import com.codearms.maoqiqi.one.listener.SuccessListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * ViewModel 基类
 * author: March
 * date: 2020/8/14 14:42
 * version v1.0.0
 */
abstract class BaseViewModel : ViewModel() {

//    protected fun <T> request(
//        block: suspend () -> CommonBean<T>,
//        result: MutableLiveData<Result<T>>,
//        isShowLoading: Boolean = false,
//        loadingMessage: String = "",
//        delayTime: Long = 0,
//        callParams: () -> HashMap<String, Any>? = { null },
//    ): Job = viewModelScope.launch {
//        try {
//            if (isShowLoading) result.value = Result.Loading(System.currentTimeMillis())
//            if (delayTime != 0L) delay(delayTime)
//            val resp = block()
//            if (resp.isSuccess()) {
//                Log.e("info", "resp.data:${resp.data}")
//                result.value = Result.Success(resp.data)
//            } else {
//                result.value = Result.Error(ApiException(resp.errorCode, resp.errorMessage, resp.data))
//            }
//        } catch (e: Exception) {
//            Log.e("info", "callParams:${callParams()}")
//            result.value = Result.Error(e)
//        }
//    }

    protected fun <T> request(
        block: suspend () -> Call<CommonBean<T>>,
        delayTime: Long = 0,
        success: SuccessListener<T>
    ): Job = viewModelScope.launch(Dispatchers.IO) {
        try {
            LogUtils.e("++++" + (Looper.getMainLooper().thread == Thread.currentThread()))
            if (delayTime != 0L) delay(delayTime)
            block().enqueue(object : Callback<CommonBean<T>> {
                override fun onResponse(call: Call<CommonBean<T>>, response: Response<CommonBean<T>>) {
                    if (response.isSuccessful) {
                        val body: CommonBean<T>? = response.body()
                        if (body == null) {

                        } else {
                            if (body.errorCode == 0) {
                                LogUtils.e("====" + (Looper.getMainLooper().thread == Thread.currentThread()))
                                success.onSuccess(body.data)
                            } else {

                            }
                        }
                    }
                }

                override fun onFailure(call: Call<CommonBean<T>>, t: Throwable) {
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}