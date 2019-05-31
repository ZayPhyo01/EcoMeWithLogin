package com.example.ecome.mvp.presenter

import com.example.ecome.data.model.ILogin
import com.example.ecome.data.model.UserModel
import com.example.ecome.data.vos.LoginVO
import com.example.ecome.mvp.view.LoginView

class LoginPresenter() : BasePresenter<LoginView>(),ILoginPresenter {

    val userModel : UserModel

    init {
        userModel = UserModel.getInstance()
    }


    override fun onTapLogin() {
        mView.showProgress()
        userModel.login(" 3","e",object : ILogin.LoginDelegate{
            override fun onFail(message: String) {
                 mView.hideProgress()
            }

            override fun onSuccess(loginVO: LoginVO) {

                mView.login()
                mView.hideProgress()
            }
        })

    }
}