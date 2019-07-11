package com.example.ecome.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.ecome.data.model.ProductModel
import com.example.ecome.data.vos.ProductVO

class DetailViewModel : ViewModel(),IDetailViewModel {
    val mProductModel = ProductModel
    override fun getDetailProduct(id: Int) : LiveData<ProductVO> {
         return mProductModel.getProductsById(id)
    }
}