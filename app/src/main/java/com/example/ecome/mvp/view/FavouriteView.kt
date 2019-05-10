package com.example.ecome.mvp.view

import com.example.ecome.data.vos.ProductVO

interface FavouriteView {
    fun showFavoriteList(favouriteProducts : MutableList<ProductVO>)
}