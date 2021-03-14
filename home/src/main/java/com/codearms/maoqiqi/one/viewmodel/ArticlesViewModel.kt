package com.codearms.maoqiqi.one.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.codearms.maoqiqi.one.OneRepository
import com.codearms.maoqiqi.one.base.BaseViewModel
import com.codearms.maoqiqi.one.bean.ArticleBean

class ArticlesViewModel : BaseViewModel() {

    private val _getHomeArticles = MutableLiveData<List<ArticleBean>>()
    val getHomeArticles: LiveData<List<ArticleBean>> = _getHomeArticles

    fun getHomeArticles() {
        request({ OneRepository().getTopArticles() }) {
            Log.e("mfq", it.toString())
            _getHomeArticles.value = it
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