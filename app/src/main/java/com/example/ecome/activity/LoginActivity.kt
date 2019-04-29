package com.example.ecome.activity

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.ecome.R
import com.example.ecome.data.model.ILogin
import com.example.ecome.data.model.UserModel
import com.example.ecome.data.vos.LoginVO
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {
     var userModel: UserModel

    init {
        userModel = UserModel.getInstance()
    }

    companion object{
        fun newIntent(context : Context) :Intent{
            var intent = Intent(context,LoginActivity::class.java)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        login.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                userModel.login(edt_user_name.text.toString(), edt_pwd.text.toString(), object : ILogin.LoginDelegate {
                    override fun onSuccess(loginVO: LoginVO) {

                        login.alpha = 0.4f
                        startActivity(MainActivity.newIntent(applicationContext))
                        finish()

                    }

                    override fun onFail(message: String) {
                        //progressBar.cancel()
                        Log.d("login","fail")
                    }
                })

            }
        })
    }

}