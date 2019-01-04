package test.app.com.logintest.data.remote.intercepter

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import test.app.com.logintest.utils.Constants

import java.io.IOException

class RequestInterceptor(context: Context) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val builder = original.newBuilder()

        // TODO : This value will be change based on requirements.
        builder.addHeader(Constants.KEY_HEADER_IMSI, "357175048449937")
        builder.addHeader(Constants.KEY_HEADER_IMEI, "510110406068589")

        val request = builder.method(original.method(), original.body()).build()
        return chain.proceed(request)
    }
}