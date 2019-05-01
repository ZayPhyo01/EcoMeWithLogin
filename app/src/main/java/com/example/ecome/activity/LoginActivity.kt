package com.example.ecome.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.ecome.R
import com.example.ecome.data.model.ILogin
import com.example.ecome.data.model.UserModel
import com.example.ecome.data.vos.LoginVO
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : BaseActivity() {

    val userModel: UserModel

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

    init {
        userModel = UserModel.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
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
                        Log.d("login", "fail")
                    }
                })

            }
        })
    }

}