package com.example.ecome.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.ecome.data.model.ProductModel
import com.example.ecome.data.model.UserModel
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.mvp.view.HistoryView

class HistoryPresenter( ) : BasePresenter<HistoryView>(), IHistoryPresenter {

    val productModel: ProductModel
    val userModel: UserModel

    init {
        productModel = ProductModel.getInstance()
        userModel = UserModel.getInstance()
    }



    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        mView.showUserAddress(userModel.getUserProfile().address)
        mView.showUserImage(userModel.getUserProfile().profile_image)
        mView.showUserName(userModel.getUserProfile().name)
        productModel.getProductHistory().observe(lifecycleOwner,object : Observer<MutableList<ProductVO>>{
            override fun onChanged(t: MutableList<ProductVO>?) {
                mView.showHistoryList(t!!)
            }
        })

    }
}