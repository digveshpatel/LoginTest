package test.app.com.logintest.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.Unbinder
import dagger.android.AndroidInjection

abstract class BaseActivity : AppCompatActivity() {

    private var unbind: Unbinder? = null

    abstract val layout: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        configureDagger()
        unbind = ButterKnife.bind(this)
        viewSetup()
        viewModelSetUp()
    }

    abstract fun viewModelSetUp()

    abstract fun viewSetup()

    override fun onDestroy() {
        super.onDestroy()
        unbind!!.unbind()
    }

    private fun configureDagger() {
        AndroidInjection.inject(this)
    }

}