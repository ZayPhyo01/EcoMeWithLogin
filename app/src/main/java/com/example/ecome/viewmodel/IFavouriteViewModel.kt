package com.example.ecome.viewmodel

import androidx.lifecycle.LiveData
import com.example.ecome.data.vos.FavouriteVO
import com.example.ecome.data.vos.ProductVO

interface IFavouriteViewModel {
    fun getFavouriteItem() : LiveData<MutableList<ProductVO>>
}