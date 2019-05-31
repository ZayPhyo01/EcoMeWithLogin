package com.example.ecome.mvp.view

import com.example.ecome.data.model.UserModel
import com.example.ecome.data.vos.LoginVO
import com.example.ecome.data.vos.ProductVO

interface HistoryView : BaseView{
    fun showHistoryList(products : MutableList<ProductVO>)
    fun showUserName(name : String)
    fun showUserAddress(address : String)
    fun showUserImage(imageUrl : String)
}