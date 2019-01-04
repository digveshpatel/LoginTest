package test.app.com.logintest.data.remote.retrofit

import android.content.Context
import okhttp3.OkHttpClient
import test.app.com.logintest.BuildConfig
import test.app.com.logintest.data.remote.intercepter.NetworkInterceptor
import test.app.com.logintest.data.remote.intercepter.RequestInterceptor

import java.util.concurrent.TimeUnit

abstract class CommonRetrofit<T>(private val context: Context) : BaseRetrofit<T>() {

    override val baseUrl: String
        get() = BuildConfig.STAGING_URL

    override fun okHttpClientHandler(builder: OkHttpClient.Builder): OkHttpClient.Builder {
        builder.connectTimeout(60, TimeUnit.SECONDS)
        builder.readTimeout(60, TimeUnit.SECONDS)
        builder.writeTimeout(60, TimeUnit.SECONDS)
        builder.addInterceptor(NetworkInterceptor(context))
        builder.addInterceptor(RequestInterceptor(context))
        return super.okHttpClientHandler(builder)
    }
}