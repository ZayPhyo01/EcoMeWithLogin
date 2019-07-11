package com.example.ecome.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.ecome.data.model.ProductModel
import com.example.ecome.data.vos.FavouriteVO
import com.example.ecome.data.vos.ProductVO

class FavouriteViewModel : ViewModel(), IFavouriteViewModel {
    val productModel = ProductModel
    override fun getFavouriteItem(): LiveData<MutableList<ProductVO>> {
         return productModel.getFavouriteProuduct()
    }
}