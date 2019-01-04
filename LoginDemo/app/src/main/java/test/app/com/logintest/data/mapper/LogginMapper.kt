package test.app.com.logintest.data.mapper

import com.google.gson.Gson
import okhttp3.ResponseBody
import retrofit2.Response
import test.app.com.logintest.data.remote.retrofit.model.LoginResponse

import javax.inject.Inject
import java.io.IOException

class LogginMapper @Inject
constructor() {

    @Throws(IOException::class)
    fun transform(response: Response<ResponseBody>?): LoginResponse {
        var loginResponse = LoginResponse()
        if (response?.body() != null) {
            loginResponse = Gson().fromJson<Any>(response.body()!!.string(), LoginResponse::class.java) as LoginResponse
        }
        return loginResponse
    }
}