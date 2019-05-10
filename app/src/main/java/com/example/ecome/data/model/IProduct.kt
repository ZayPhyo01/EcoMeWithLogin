package com.example.ecome.data.model

import com.example.ecome.data.vos.ProductVO

interface IProduct {

    fun getProducts(delegate: ProductDelegate) : MutableList<ProductVO>

    fun getProductsById(id : Int) : ProductVO

    fun favouriteWithId(id : Int)

    fun unFavouriteWithId(id : Int)

    fun getFavouriteProuduct() : MutableList<ProductVO>

    fun getProductHistory() : MutableList<ProductVO>

    fun saveProductHistoryWithId(id : Int)

    interface ProductDelegate{
        fun onSuccess(products : MutableList<ProductVO>)
        fun onError(message : String)
    }
}