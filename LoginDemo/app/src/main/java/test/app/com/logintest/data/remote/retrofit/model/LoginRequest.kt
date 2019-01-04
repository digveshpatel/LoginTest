package test.app.com.logintest.data.remote.retrofit.model

import com.google.gson.annotations.SerializedName

class LoginRequest(
    @field:SerializedName("username")
    var userName: String?,
    @field:SerializedName("password")
    var pwd: String?
)