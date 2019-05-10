package com.example.ecome.mvp.presenter

interface IHomePresenter {

    fun onUiReady()
    fun onTapFav(id : Int)
    fun onTapUnFav(id : Int)
    fun onTapItem(id : Int)



}