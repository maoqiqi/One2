package com.codearms.maoqiqi.one

import com.codearms.maoqiqi.one.bean.ArticleBean
import com.codearms.maoqiqi.one.bean.BannerBean
import com.codearms.maoqiqi.one.bean.CommonBean
import retrofit2.Call

class OneRepository {

    fun getBanner(): Call<CommonBean<List<BannerBean>>> {
        return RetrofitManager.getInstance().serverApi.getBanner()
    }

    fun getTopArticles(): Call<CommonBean<List<ArticleBean>>> {
        return RetrofitManager.getInstance().serverApi.getTopArticles()
    }
}