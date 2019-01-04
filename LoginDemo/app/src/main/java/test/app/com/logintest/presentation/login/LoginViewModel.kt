package test.app.com.logintest.presentation.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.subscribers.ResourceSubscriber
import test.app.com.logintest.data.remote.retrofit.model.LoginResponse
import test.app.com.logintest.domain.usecase.LoginUseCase

import javax.inject.Inject

class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {

    internal var mutableLoginLiveData = MutableLiveData<LoginResponse>()


    fun callLoginWebservice(emailId: String, password: String) {
        loginUseCase.executeFlowable(object : ResourceSubscriber<LoginResponse>() {
            override fun onNext(loginResponse: LoginResponse) {
                mutableLoginLiveData.postValue(loginResponse)
            }

            override fun onError(t: Throwable) {
                Log.e("LoginViewModel", t.message)
            }

            override fun onComplete() {}
        }, LoginUseCase.Params(emailId, password))

    }

}