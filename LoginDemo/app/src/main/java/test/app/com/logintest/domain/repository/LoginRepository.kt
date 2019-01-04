package test.app.com.logintest.domain.repository

import io.reactivex.Flowable
import test.app.com.logintest.data.remote.retrofit.model.LoginResponse

interface LoginRepository {
    fun postLogin(name: String, password: String): Flowable<LoginResponse>
}