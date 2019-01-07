package test.app.com.logintest.presentation.login

import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import javax.inject.Inject
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_login.*
import test.app.com.logintest.R
import test.app.com.logintest.presentation.base.BaseActivity
import test.app.com.logintest.utils.Utility

class LoginActivity : BaseActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private var loginViewModel: LoginViewModel? = null

    override val layout: Int
        get() = R.layout.activity_login

    override fun viewModelSetUp() {
        loginViewModel = ViewModelProviders.of(this, factory).get(LoginViewModel::class.java)
        loginViewModel?.mutableLoginLiveData?.observe(this, Observer {
            showProgressBar(false);
            Toast.makeText(this@LoginActivity, it, Toast.LENGTH_SHORT).show();
        })
    }


    override fun viewSetup() {
        progressBar.visibility = View.GONE
        btnLogin!!.setOnClickListener {
            Utility.hideKeyboard(this@LoginActivity)
            showProgressBar(true);
            loginViewModel?.checkValidationAndCallLoginWs(this@LoginActivity,
                edtEmail.text.toString().trim (),
                edtPassword.text.toString().trim())
        }
    }


    fun showProgressBar(isShow: Boolean) {
        if (isShow) {
            progressBar.visibility = View.VISIBLE
            btnLogin.isEnabled = false;
            btnLogin.isClickable = false;
        } else {
            progressBar.visibility = View.GONE
            btnLogin.isEnabled = true;
            btnLogin.isClickable = true;
        }
    }
}