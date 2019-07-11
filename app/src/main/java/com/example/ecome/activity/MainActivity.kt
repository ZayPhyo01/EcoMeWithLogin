package com.example.ecome.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.example.ecome.R
import com.example.ecome.adapter.HomePagerAdapter
import com.example.ecome.data.model.UserModel
import com.example.ecome.fragment.HomeFragment
import com.example.ecome.fragment.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {


    val userModel: UserModel
    var keep: Boolean = false

    init {
        userModel = UserModel.getInstance()
    }

    companion object {

        fun newIntent(context: Context): Intent {
            val intent = Intent(context, MainActivity::class.java)
            return intent

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!userModel.isLogin()) {
            startActivity(LoginActivity.newIntent(applicationContext))
            finish()
        }


        vp_home.adapter = HomePagerAdapter(supportFragmentManager)


        tabHome.setupWithViewPager(vp_home)
        tabHome.getTabAt(0)!!.icon = resources.getDrawable(R.drawable.ic_home_black_24dp)
        tabHome.getTabAt(1)!!.icon = resources.getDrawable(R.drawable.ic_person_black_24dp)

        fav.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startActivity(FavouriteActivity.newIntent(applicationContext))
            }
        })

    }

    override fun onBackPressed() {

        Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show()
        if (keep) {
            finish()
        }

        keep = true

    }


}
