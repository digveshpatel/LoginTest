package test.app.com.logintest.data.remote.retrofit

import io.reactivex.Flowable
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import test.app.com.logintest.data.remote.retrofit.model.LoginRequest

interface BaseApi {

    @POST("login")
    fun postLogin(@Body loginRequest: LoginRequest): Flowable<Response<ResponseBody>>
}