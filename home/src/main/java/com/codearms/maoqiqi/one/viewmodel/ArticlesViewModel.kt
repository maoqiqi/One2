package com.codearms.maoqiqi.one.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.codearms.maoqiqi.one.BaseViewModel
import com.codearms.maoqiqi.one.OneRepository
import com.codearms.maoqiqi.one.bean.ArticleBean
import com.codearms.maoqiqi.one.bean.CommonBean
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticlesViewModel : BaseViewModel() {

    private val _getHomeArticles = MutableLiveData<List<ArticleBean>>()
    val getHomeArticles: LiveData<List<ArticleBean>> = _getHomeArticles

    fun getHomeArticles() {
        viewModelScope.launch {
            OneRepository().getTopArticles().enqueue(object : Callback<CommonBean<List<ArticleBean>>> {
                override fun onResponse(call: Call<CommonBean<List<ArticleBean>>>, response: Response<CommonBean<List<ArticleBean>>>) {
                    Log.e("mfq", response.body().toString())
                    _getHomeArticles.postValue(response.body()?.data)
                }

                override fun onFailure(call: Call<CommonBean<List<ArticleBean>>>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }
    }

    fun getWxArticles(id: Int, refresh: Boolean) {
        TODO("Not yet implemented")
    }

    fun getProjectArticles(id: Int, refresh: Boolean) {
        TODO("Not yet implemented")
    }

    fun getKnowledgeArticles(id: Int, refresh: Boolean) {
        TODO("Not yet implemented")
    }

    fun getCollect(refresh: Boolean) {
        TODO("Not yet implemented")
    }

    fun query(k: String?, refresh: Boolean) {
        TODO("Not yet implemented")
    }
}