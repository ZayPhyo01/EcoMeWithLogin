package com.example.ecome.viewmodel

import androidx.lifecycle.LiveData
import com.example.ecome.data.vos.CategoryVO
import com.example.ecome.data.vos.ProductVO

interface IHomeViewModel {
    fun getCategories(): LiveData<MutableList<CategoryVO>>
    fun getProducts(): LiveData<MutableList<ProductVO>>
    fun onTapFavourite(id : Int)
    fun onTapUnFavourite(id : Int)
    fun onTapItem(id : Int)
}