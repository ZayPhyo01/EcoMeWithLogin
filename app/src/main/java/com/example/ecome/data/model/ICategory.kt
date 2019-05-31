package com.example.ecome.data.model

import androidx.lifecycle.LiveData
import com.example.ecome.data.vos.CategoryVO

interface ICategory {
    fun getCategoryList( ) : LiveData<MutableList<CategoryVO>>

}