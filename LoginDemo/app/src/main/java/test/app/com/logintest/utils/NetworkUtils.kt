package test.app.com.logintest.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object NetworkUtils {

    fun getNetworkInfo(context: Context): NetworkInfo? {
        val cm = context
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo
    }

    fun hasNetwork(context: Context): Boolean {
        val info = NetworkUtils.getNetworkInfo(context)
        return info != null && info.isConnectedOrConnecting
    }

}