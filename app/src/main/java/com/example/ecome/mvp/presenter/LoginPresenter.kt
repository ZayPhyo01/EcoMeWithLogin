package com.example.ecome.mvp.presenter

import com.example.ecome.data.model.ILogin
import com.example.ecome.data.model.UserModel
import com.example.ecome.data.vos.LoginVO
import com.example.ecome.mvp.view.LoginView

class LoginPresenter(val loginView: LoginView) : BasePresenter(),ILoginPresenter {

    val userModel : UserModel

    init {
        userModel = UserModel.getInstance()
    }

    override fun onCreate() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStart() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTapLogin() {
        loginView.showProgress()
        userModel.login(" 3","e",object : ILogin.LoginDelegate{
            override fun onFail(message: String) {
                 loginView.hideProgress()
            }

            override fun onSuccess(loginVO: LoginVO) {

                loginView.login()
                loginView.hideProgress()
            }
        })

    }
}