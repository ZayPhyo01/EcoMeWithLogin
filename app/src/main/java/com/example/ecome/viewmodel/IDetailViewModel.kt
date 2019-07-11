package com.example.ecome.viewmodel

import androidx.lifecycle.LiveData
import com.example.ecome.data.model.ProductModel
import com.example.ecome.data.vos.ProductVO

interface IDetailViewModel {

    fun getDetailProduct(id: Int): LiveData<ProductVO>
}