/*
 * Copyright [2020] [March]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.codearms.maoqiqi.one

import androidx.lifecycle.ViewModel

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
}