package com.example.ecome.data.model

import com.example.ecome.data.vos.CategoryVO

interface ICategory {
    fun getCategoryList(result : CategoryResult) : MutableList<CategoryVO>
    interface CategoryResult {
        fun onSuccess(categories: MutableList<CategoryVO>)
        fun onError(message: String)
    }
}