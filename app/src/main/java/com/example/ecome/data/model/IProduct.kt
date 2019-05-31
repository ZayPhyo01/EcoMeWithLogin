package com.example.ecome.data.model

import androidx.lifecycle.LiveData
import com.example.ecome.data.vos.ProductVO

interface IProduct {

    fun getProducts( ) :LiveData<MutableList<ProductVO>>

    fun getProductsById(id : Int) : LiveData<ProductVO>

    fun favouriteWithId(id : Int)

    fun unFavouriteWithId(id : Int)

    fun getFavouriteProuduct() : LiveData<MutableList<ProductVO>>

    fun getProductHistory() : LiveData<MutableList<ProductVO>>

    fun saveProductHistoryWithId(id : Int)


}