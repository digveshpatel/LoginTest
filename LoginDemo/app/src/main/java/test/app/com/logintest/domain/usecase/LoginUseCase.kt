package test.app.com.logintest.domain.usecase

import io.reactivex.Flowable
import test.app.com.logintest.data.remote.retrofit.model.LoginResponse
import test.app.com.logintest.domain.UseCase
import test.app.com.logintest.domain.repository.LoginRepository

import javax.inject.Inject

class LoginUseCase @Inject
constructor(private val loginRepository: LoginRepository) : UseCase<LoginResponse, LoginUseCase.Params>() {

    override fun buildUseCaseFlowable(params: Params?): Flowable<LoginResponse> {
        return loginRepository.postLogin(params!!.name, params.password)
    }

    class Params(val name: String, val password: String)
}