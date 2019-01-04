package test.app.com.logintest.presentation.login

import android.widget.Button
import android.widget.EditText


import javax.inject.Inject

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import butterknife.BindView
import test.app.com.logintest.R
import test.app.com.logintest.presentation.base.BaseActivity

class LoginActivity : BaseActivity() {

    @BindView(R.id.edtEmail)
    lateinit var edtEmail: EditText

    @BindView(R.id.edtPassword)
    lateinit var edtPassword: EditText

    @BindView(R.id.btnLogin)
    lateinit var btnLogin: Button

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private var loginViewModel: LoginViewModel? = null

    override val layout: Int
        get() = R.layout.activity_login

    override fun viewModelSetUp() {
        loginViewModel = ViewModelProviders.of(this, factory).get(LoginViewModel::class.java)
    }


     override fun viewSetup() {
         btnLogin = findViewById(R.id.btnLogin)
         edtEmail = findViewById(R.id.edtEmail)
         edtPassword = findViewById(R.id.edtPassword)
         btnLogin!!.setOnClickListener {
             loginViewModel!!.callLoginWebservice(
                 edtEmail!!.text.toString().trim { it <= ' ' },
                 edtPassword!!.text.toString().trim { it <= ' ' })
         }
     }



}