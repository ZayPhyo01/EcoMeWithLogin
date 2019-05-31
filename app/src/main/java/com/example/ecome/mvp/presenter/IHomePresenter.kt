package com.example.ecome.mvp.presenter

import androidx.lifecycle.LifecycleOwner

interface IHomePresenter {

    fun onUiReady(lifecycleOwner: LifecycleOwner)
    fun onTapFav(id : Int)
    fun onTapUnFav(id : Int)
    fun onTapItem(id : Int)



}