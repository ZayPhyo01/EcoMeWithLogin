package com.example.ecome.mvp.presenter

import com.example.ecome.data.model.ProductModel
import com.example.ecome.data.model.UserModel
import com.example.ecome.mvp.view.HistoryView

class HistoryPresenter(var mHistoryView: HistoryView) : BasePresenter(), IHistoryPresenter {

    val productModel: ProductModel
    val userModel: UserModel

    init {
        productModel = ProductModel.getInstance()
        userModel = UserModel.getInstance()
    }

    override fun onCreate() {

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

    override fun onUiReady() {
        mHistoryView.showUserAddress(userModel.getUserProfile().address)
        mHistoryView.showUserImage(userModel.getUserProfile().profile_image)
        mHistoryView.showUserName(userModel.getUserProfile().name)
        mHistoryView.showHistoryList(productModel.getProductHistory())
    }
}