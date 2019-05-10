package com.example.ecome.mvp.presenter

abstract class BasePresenter {

    abstract fun onCreate()
    abstract fun onStart()
    abstract fun onStop()
    abstract fun onDestroy()
}