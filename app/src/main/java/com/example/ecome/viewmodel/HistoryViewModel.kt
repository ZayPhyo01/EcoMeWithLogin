package com.example.ecome.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.ecome.data.model.ProductModel
import com.example.ecome.data.vos.ProductVO

class HistoryViewModel : ViewModel() , IHistroyViewModel {
    override fun getAllHistory(): LiveData<MutableList<ProductVO>> {
         return productModel.getProductHistory()
    }

    val productModel = ProductModel

}