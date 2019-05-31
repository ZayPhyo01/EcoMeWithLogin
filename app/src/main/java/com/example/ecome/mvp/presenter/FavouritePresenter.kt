package com.example.ecome.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.ecome.data.model.ProductModel
import com.example.ecome.data.vos.FavouriteVO
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.mvp.view.FavouriteView
import com.example.ecome.mvp.view.HomeView

class FavouritePresenter : BasePresenter<FavouriteView>() , IFavouritePresenter{

    val productModel : ProductModel

    init {
        productModel = ProductModel.getInstance()
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        productModel.getFavouriteProuduct().observe(lifecycleOwner,object : Observer<MutableList<ProductVO>>{
            override fun onChanged(t: MutableList<ProductVO>?) {
               mView.showFavoriteList(t!!)  }

        })


    }


}