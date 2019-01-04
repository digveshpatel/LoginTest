package test.app.com.logintest.data.local.db

import android.content.Context
import io.reactivex.Flowable
import okhttp3.ResponseBody
import retrofit2.Response
import test.app.com.logintest.data.remote.retrofit.LoginEntityData

class LocalEntityData(context: Context) : BasePersistence(context), LoginEntityData {

    override fun postLogin(name: String, password: String): Flowable<Response<ResponseBody>>? {
        return null
    }

    override fun saveUserXaccToLocal(xaccData: XaccData) {
        db!!.loginDao.insertXaccData(xaccData)
    }
}