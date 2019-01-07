package test.app.com.logintest.domain.usecase

import io.reactivex.Flowable
import test.app.com.logintest.data.remote.login.model.LoginResponse
import test.app.com.logintest.domain.UseCase
import test.app.com.logintest.domain.modal.LoginData
import test.app.com.logintest.domain.repository.LoginRepository

import javax.inject.Inject

class LoginUseCase @Inject
constructor(private val loginRepository: LoginRepository) : UseCase<LoginData, LoginUseCase.Params>() {

    override fun buildUseCaseFlowable(params: Params?): Flowable<LoginData> {
        return loginRepository.postLogin(params!!.name, params.password)
    }

    class Params(val name: String, val password: String)
}