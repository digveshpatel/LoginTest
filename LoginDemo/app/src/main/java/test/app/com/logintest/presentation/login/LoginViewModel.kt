package test.app.com.logintest.presentation.login

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.subscribers.ResourceSubscriber
import test.app.com.logintest.R
import test.app.com.logintest.domain.modal.LoginData
import test.app.com.logintest.domain.usecase.LoginUseCase
import test.app.com.logintest.utils.Utility

import javax.inject.Inject

class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {

    internal var mutableLoginLiveData = MutableLiveData<String>()

    fun checkValidationAndCallLoginWs(context: Context, emailId: String, password: String) {
        if (checkValidation(context,emailId, password)) {
            loginUseCase.executeFlowable(object : ResourceSubscriber<LoginData>() {
                override fun onNext(loginData: LoginData) {
                    mutableLoginLiveData.postValue(loginData.errorMessage)
                }

                override fun onError(t: Throwable) {
                    mutableLoginLiveData.postValue(t.localizedMessage)
                }

                override fun onComplete() {}
            }, LoginUseCase.Params(emailId, password))
        }
    }

    fun checkValidation(context: Context, emailId: String, password: String): Boolean {
        if(! Utility.isValidEmail(emailId)){
            mutableLoginLiveData.postValue(context.getString(R.string.invalid_login))
            return false;
        }else if(password.length == 0){
            mutableLoginLiveData.postValue(context.getString(R.string.invalid_password))
            return false;
        }
        return true;
    }
}