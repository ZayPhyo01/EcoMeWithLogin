package com.example.ecome.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import com.example.ecome.R
import com.example.ecome.view.viewpod.ProfileViewPod
import kotlinx.android.synthetic.main.fragement_profile.*

class ProfileActivity : BaseActivity() {

    companion object {
        fun newIntent(context: Context): Intent {
            var intent = Intent(context, ProfileActivity::class.java)
            return intent

        }
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.fragement_profile)
        relative_layout.addView(ProfileViewPod(applicationContext),1)
    }
}