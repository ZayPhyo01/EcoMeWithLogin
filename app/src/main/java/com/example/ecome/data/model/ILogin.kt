package com.example.ecome.data.model

import com.example.ecome.data.vos.LoginVO

interface ILogin {

    fun login(phone: String, pw: String,loginDelegate: LoginDelegate )

    fun isLogin(): Boolean

    fun getUserProfile() : LoginVO

    fun logout()

    interface LoginDelegate {
        fun onSuccess(loginVO: LoginVO)
        fun onFail(message: String)


    }
}