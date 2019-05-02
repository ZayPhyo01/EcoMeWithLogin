package com.example.ecome.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.ecome.R
import com.example.ecome.data.model.UserModel
import kotlinx.android.synthetic.main.fragement_profile.*

class ProfileFragment : BaseFragment() {

    companion object {
              fun newInstance(): ProfileFragment {
                  return ProfileFragment()
              }
          }
    var userModel : UserModel

    init {
        userModel = UserModel.getInstance()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragement_profile,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Glide.with(context!!)
            .load(userModel.getUserProfile())
            .into(imvProfile)
        tvProfileName.setText(userModel.getUserProfile().name)
        tvProfileAddress.setText(userModel.getUserProfile().address)

    }
}