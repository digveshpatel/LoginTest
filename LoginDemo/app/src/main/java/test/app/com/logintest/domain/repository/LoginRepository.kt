package test.app.com.logintest.domain.repository

import io.reactivex.Flowable
import test.app.com.logintest.domain.modal.LoginData

interface LoginRepository {
    fun postLogin(name: String, password: String): Flowable<LoginData>
}