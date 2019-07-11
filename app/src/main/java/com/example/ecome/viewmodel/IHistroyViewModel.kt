package com.example.ecome.viewmodel

import androidx.lifecycle.LiveData
import com.example.ecome.data.vos.ProductVO

interface IHistroyViewModel {
    fun getAllHistory() : LiveData<MutableList<ProductVO>>
}