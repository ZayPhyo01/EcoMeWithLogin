package com.example.ecome.mvp.presenter

import com.example.ecome.data.model.ProductModel
import com.example.ecome.mvp.view.FavouriteView
import com.example.ecome.mvp.view.HomeView

class FavouritePresenter (val favouriteView: FavouriteView): BasePresenter() , IFavouritePresenter{

    val productModel : ProductModel

    init {
        productModel = ProductModel.getInstance()
    }

    override fun onUiReady() {
        favouriteView.showFavoriteList(productModel.getFavouriteProuduct())

    }

    override fun onCreate() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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
}