package com.example.ecome.data.model

import com.example.ecome.data.vos.LoginVO
import com.example.ecome.delegate.BaseDelegate
import com.example.ecome.network.response.LoginResponse

object UserModel : BaseModel(), ILogin {

    override fun getUserProfile(): LoginVO {
        return mEcoDatabase.getUserDao().getUserLogin()
    }

    override fun isLogin(): Boolean = !mEcoDatabase.getUserDao().isEmpty(mEcoDatabase.getUserDao())


    override fun login(phone: String, pw: String, loginDelegate: ILogin.LoginDelegate) {
        mDataAgent.login(phone, pw, object : BaseDelegate<LoginResponse> {
            override fun fail(message: String) {
                loginDelegate.onFail("fail login")
            }

            override fun success(dataVo: LoginResponse) {
                loginDelegate.onSuccess(dataVo.login_user)
                mEcoDatabase.getUserDao().saveUserLogin(dataVo.login_user)
            }
        })

    }


    override fun logout() {


    }
}