package com.codearms.maoqiqi.one

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private val BASE_URL: String = "https://www.wanandroid.com/"

    // 读超时长,单位：毫秒
    private const val READ_TIME_OUT = 10000L

    // 连接时长,单位：毫秒
    private const val CONNECT_TIME_OUT = 10000L

    // 日志拦截器
    private var httpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    // OkHttp对象
    private var okHttpClient = OkHttpClient.Builder()
        .addInterceptor(HeaderInterceptor())
        .addInterceptor(httpLoggingInterceptor)
        .readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
        .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ServerApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return@lazy retrofit.create(ServerApi::class.java)
    }

    class HeaderInterceptor : Interceptor {

        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val oldRequest = chain.request()
            // 新的请求
            val builder = oldRequest.newBuilder()
            if (headers.isNotEmpty()) {
                for (index in headers.entries) {
                    builder.addHeader(index.key, index.value)
                }
            }
            val newRequest = builder.build()
            return chain.proceed(newRequest)
        }

        companion object {
            @JvmField
            var headers: HashMap<String, String> = hashMapOf()

            @JvmStatic
            fun setHeaders(headers: Map<String, String>) {
                headers.forEach(action = { entry ->
                    HeaderInterceptor.headers[entry.key] = entry.value
                })
            }
        }
    }
}