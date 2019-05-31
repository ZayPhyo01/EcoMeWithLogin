package com.example.ecome.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.example.ecome.data.vos.ProductVO

interface IDetailProductPresenter {
    fun onUiReady(id : Int,lifecycleOwner: LifecycleOwner)
}