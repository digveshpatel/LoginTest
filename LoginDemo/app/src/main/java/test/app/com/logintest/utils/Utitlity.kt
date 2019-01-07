package test.app.com.logintest.utils

import android.app.Activity
import android.content.Context
import android.util.Patterns
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService



object Utility {

    fun isValidEmail(email:String): Boolean
            = email.isNotEmpty() &&
            Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun hideKeyboard(context : Context) {
        val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm?.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
    }


}