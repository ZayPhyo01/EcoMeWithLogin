package com.example.ecome.mvp.presenter

import androidx.lifecycle.ViewModel
import com.example.ecome.mvp.view.BaseView

abstract class BasePresenter<T : BaseView> : ViewModel() {
    lateinit var mView:T
    fun initView(view : T){
        mView = view
    }

}