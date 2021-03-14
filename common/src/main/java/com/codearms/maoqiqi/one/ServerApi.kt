package com.codearms.maoqiqi.one

import com.codearms.maoqiqi.one.bean.*
import retrofit2.Call
import retrofit2.http.*

interface ServerApi {

    /**
     * 首页Banner(https://www.wanandroid.com/banner/json)
     * @return Banner数据
     */
    @GET("banner/json")
    fun getBanner(): Call<CommonBean<List<BannerBean>>>

    /**
     * 常用网站(https://www.wanandroid.com/friend/json)
     * @return 常用网站数据
     */
    @GET("friend/json")
    fun getUsefulSites(): Call<CommonBean<List<UsefulSitesBean>>>

    /**
     * 热词(https://www.wanandroid.com/hotkey/json)
     * @return 热词数据
     */
    @GET("hotkey/json")
    fun getHotKey(): Call<CommonBean<List<HotKeyBean>>>

    /**
     * 置顶文章(https://www.wanandroid.com/article/top/json)
     * @return 置顶文章数据
     */
    @GET("article/top/json")
    fun getTopArticles(): Call<CommonBean<List<ArticleBean>>>

    /**
     * 首页文章列表(https://www.wanandroid.com/article/list/0/json)
     * @param page 页码,拼接在链接上,从0开始
     * @return 文章列表数据
     */
    @GET("article/list/{page}/json")
    fun getArticles(@Path("page") page: Int): Call<CommonBean<ArticleBeans>>

    /**
     * 导航数据(https://www.wanandroid.com/navi/json)
     * @return 导航数据
     */
    @GET("navi/json")
    fun getNavigation(): Call<CommonBean<List<NavigationBean>>>

    /**
     * 获取公众号列表(https://wanandroid.com/wxarticle/chapters/json)
     * @return 公众号列表数据
     */
    @GET("wxarticle/chapters/json")
    fun getWxList(): Call<CommonBean<List<ChildClassifyBean>>>

    /**
     * 查看某个公众号历史数据(https://wanandroid.com/wxarticle/list/408/1/json)
     * @param id   公众号ID,拼接在链接上,eg:405
     * @param page 公众号页码,拼接在链接上,eg:1
     * @return 查看某个公众号历史数据
     */
    @GET("wxarticle/list/{id}/{page}/json")
    fun getWxArticles(@Path("id") id: Int, @Path("page") page: Int): Call<CommonBean<ArticleBeans>>

    /**
     * 在某个公众号中搜索历史文章(https://wanandroid.com/wxarticle/list/405/1/json?k=Java)
     * @param id   公众号ID,拼接在链接上,eg:405
     * @param page 公众号页码,拼接在链接上,eg:1
     * @param k    搜索内容,eg:Java
     * @return 指定搜索内容, 搜索当前公众号的某页的此类数据
     */
    @GET("wxarticle/list/{id}/{page}/json")
    fun getWxSearchArticles(@Path("id") id: Int, @Path("page") page: Int, @Query("k") k: String?): Call<CommonBean<Any>>

    /**
     * 知识体系(https://www.wanandroid.com/tree/json)
     * @return 知识体系数据
     */
    @GET("tree/json")
    fun getKnowledge(): Call<CommonBean<List<ParentClassifyBean>>>

    /**
     * 知识体系下的文章(https://www.wanandroid.com/article/list/0/json?cid=60)
     * @param page 页码,拼接在链接上,从0开始
     * @param cid  分类的id,二级目录的id
     * @return 知识体系下的文章数据
     */
    @GET("article/list/{page}/json")
    fun getKnowledgeArticles(@Path("page") page: Int, @Query("cid") cid: Int): Call<CommonBean<ArticleBeans>>

    /**
     * 项目分类(https://www.wanandroid.com/project/tree/json)
     * @return 项目分类数据
     */
    @GET("project/tree/json")
    fun getProject(): Call<CommonBean<List<ChildClassifyBean>>>

    /**
     * 项目列表数据(https://www.wanandroid.com/project/list/1/json?cid=294)
     * @param page 页码,拼接在链接上,从1开始
     * @param cid  分类的id,上面项目分类接口
     * @return 项目类别数据
     */
    @GET("project/list/{page}/json")
    fun getProjectArticles(@Path("page") page: Int, @Query("cid") cid: Int): Call<CommonBean<ArticleBeans>>

    /**
     * 登录(https://www.wanandroid.com/user/login)
     * @param username 用户名
     * @param password 密码
     * @return 登录
     */
    @POST("user/login")
    @FormUrlEncoded
    fun login(@Field("username") username: String?, @Field("password") password: String?): Call<CommonBean<UserBean>>

    /**
     * 注册(https://www.wanandroid.com/user/register)
     * @param username   用户名
     * @param password   密码
     * @param repassword 确认密码
     * @return 注册
     */
    @POST("user/register")
    @FormUrlEncoded
    fun register(
        @Field("username") username: String?,
        @Field("password") password: String?,
        @Field("repassword") repassword: String?
    ): Call<CommonBean<UserBean>>

    /**
     * 退出(https://www.wanandroid.com/user/logout/json)
     *
     * @return 退出
     */
    fun logout(): Call<CommonBean<Any>>

    /**
     * 收藏文章列表(https://www.wanandroid.com/lg/collect/list/0/json)
     *
     * @param page 页码,拼接在链接上,从0开始
     * @return 收藏文章列表数据
     */
    @GET("lg/collect/list/{page}/json")
    fun getCollect(@Path("page") page: Int): Call<CommonBean<ArticleBeans>>

    /**
     * 收藏站内文章(https://www.wanandroid.com/lg/collect/1165/json)
     * @param id 文章id,拼接在链接上
     * @return 收藏站内文章
     */
    @POST("lg/collect/{id}/json")
    fun collect(@Path("id") id: Int): Call<CommonBean<Any>>

    /**
     * 收藏站外文章(https://www.wanandroid.com/lg/collect/add/json)
     * @param title  标题
     * @param author 作者
     * @param link   链接
     * @return 收藏站外文章
     */
    @POST("lg/collect/add/json")
    @FormUrlEncoded
    fun collect(
        @Field("title") title: String?,
        @Field("author") author: String?,
        @Field("link") link: String?
    ): Call<CommonBean<ArticleBean>>

    /**
     * 取消收藏[文章列表](https://www.wanandroid.com/lg/uncollect_originId/2333/json)
     * @param id 文章id,拼接在链接上
     * @return 取消收藏
     */
    @POST("lg/uncollect_originId/{id}/json")
    fun unCollect(@Path("id") id: Int): Call<CommonBean<Any>>

    /**
     * 取消收藏[我的收藏页面](https://www.wanandroid.com/lg/uncollect/2805/json)
     * @param id       文章id,拼接在链接上
     * @param originId 源id
     * @return 取消收藏
     */
    @POST("lg/uncollect/{id}/json")
    @FormUrlEncoded
    fun unCollect(@Path("id") id: Int, @Field("originId") originId: Int): Call<CommonBean<Any>>

    /**
     * 收藏网站列表(https://www.wanandroid.com/lg/collect/usertools/json)
     * @return 收藏网站列表数据
     */
    @GET("lg/collect/usertools/json")
    fun getCollectUrl(): Call<CommonBean<Any>>

    /**
     * 收藏网址(https://www.wanandroid.com/lg/collect/addtool/json)
     * @param name name
     * @param link link
     * @return 收藏网址
     */
    @POST("lg/collect/addtool/json")
    @FormUrlEncoded
    fun collectUrl(@Field("name") name: String?, @Field("link") link: String?): Call<CommonBean<Any>>

    /**
     * 编辑收藏网站(https://www.wanandroid.com/lg/collect/updatetool/json)
     * @param id   id
     * @param name name
     * @param link link
     * @return 编辑收藏网站
     */
    @POST("lg/collect/updatetool/json")
    @FormUrlEncoded
    fun collectUrl(@Field("id") id: Int, @Field("name") name: String?, @Field("link") link: String?): Call<CommonBean<Any>>

    /**
     * 删除收藏网站(https://www.wanandroid.com/lg/collect/deletetool/json)
     * @param id id
     * @return 删除收藏网站
     */
    @POST("lg/collect/deletetool/json")
    @FormUrlEncoded
    fun unCollectUrl(@Field("id") id: Int): Call<CommonBean<Any>>

    /**
     * 搜索(https://www.wanandroid.com/article/query/0/json)
     * @param page 页码
     * @param k    搜索关键词
     * @return 搜索数据
     */
    @POST("article/query/0/json")
    @FormUrlEncoded
    fun query(@Field("page") page: Int, @Field("k") k: String?): Call<CommonBean<ArticleBeans>>
}