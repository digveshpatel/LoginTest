package test.app.com.logintest.data.remote.intercepter

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import test.app.com.logintest.R
import test.app.com.logintest.data.remote.execeptions.NetworkNotFoundException
import test.app.com.logintest.utils.NetworkUtils

import java.io.IOException

class NetworkInterceptor(private val context: Context) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        if (NetworkUtils.hasNetwork(context)) {
            return chain.proceed(request)
        }
        throw NetworkNotFoundException("No internet connection")
    }

}