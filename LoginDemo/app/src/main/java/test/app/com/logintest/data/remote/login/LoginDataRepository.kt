package test.app.com.logintest.data.remote.login

import android.content.Context
import io.reactivex.Flowable
import test.app.com.logintest.data.local.db.LocalEntityData
import test.app.com.logintest.data.local.db.XaccData
import test.app.com.logintest.data.mapper.LogginMapper
import test.app.com.logintest.data.RemoteLoginEntityData
import test.app.com.logintest.domain.modal.LoginData
import test.app.com.logintest.domain.repository.LoginRepository
import test.app.com.logintest.utils.Constants

import javax.inject.Inject

class LoginDataRepository @Inject constructor(private val mapper: LogginMapper, private val context: Context) : LoginRepository {

    override fun postLogin(name: String, password: String): Flowable<LoginData> {
        return RemoteLoginEntityData(context).postLogin(name, password)!!.doOnNext { responseBodyResponse ->
            val xaccData = XaccData()
            xaccData.userName = name
            xaccData.xacc = responseBodyResponse.headers().get(Constants.KEY_HEADER_X_ACC)
            LocalEntityData(context).saveUserXaccToLocal(xaccData)
        }.map { responseBodyResponse -> mapper.transform(responseBodyResponse) }
    }


}