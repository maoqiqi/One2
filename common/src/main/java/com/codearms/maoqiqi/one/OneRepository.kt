package com.codearms.maoqiqi.one

import com.codearms.maoqiqi.one.bean.BannerBean
import com.codearms.maoqiqi.one.bean.CommonBean

class OneRepository {

    fun getBanner(): CommonBean<List<BannerBean>> {
        return RetrofitManager.getInstance().serverApi.getBanner()
    }
}