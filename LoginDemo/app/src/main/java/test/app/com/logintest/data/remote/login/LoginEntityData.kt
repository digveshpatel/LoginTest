package test.app.com.logintest.data.remote.login

import io.reactivex.Flowable
import okhttp3.ResponseBody
import retrofit2.Response
import test.app.com.logintest.data.local.db.XaccData

interface LoginEntityData {

    fun postLogin(name: String, password: String): Flowable<Response<ResponseBody>>?

    fun saveUserXaccToLocal(xaccData: XaccData)

}