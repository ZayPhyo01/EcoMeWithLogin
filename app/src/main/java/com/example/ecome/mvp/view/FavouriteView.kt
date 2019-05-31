package com.example.ecome.mvp.view

import com.example.ecome.data.vos.ProductVO

interface FavouriteView : BaseView{
    fun showFavoriteList(favouriteProducts : MutableList<ProductVO>)
}