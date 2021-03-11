package com.codearms.maoqiqi.one

import com.codearms.maoqiqi.one.bean.BannerBean
import com.codearms.maoqiqi.one.bean.CommonBean
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext

class OneRepository {

     fun getBanner(): CommonBean<List<BannerBean>> {
        return RetrofitManager.getInstance().serverApi.getBanner()
    }
}