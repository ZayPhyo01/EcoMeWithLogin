package com.example.ecome.activity

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.example.ecome.R
import com.example.ecome.data.model.ILogin
import com.example.ecome.data.model.UserModel
import com.example.ecome.data.vos.LoginVO
import com.example.ecome.mvp.presenter.ILoginPresenter
import com.example.ecome.mvp.presenter.LoginPresenter
import com.example.ecome.mvp.view.LoginView
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : BaseActivity(), LoginView {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun showProgress() {

        loginProgress.visibility = View.VISIBLE
        loginProgress.setProgress(10,true)
    }

    override fun hideProgress() {

        loginProgress.visibility = View.INVISIBLE
            }

    override fun login() {
        startActivity(MainActivity.newIntent(this))

    }

   lateinit var loginPresenter: LoginPresenter






    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)

        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginPresenter = ViewModelProviders.of(this).get(LoginPresenter::class.java)
        loginPresenter.initView(this)
        setContentView(R.layout.activity_register)



        login.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                loginPresenter.onTapLogin()

            }
        })
    }


}