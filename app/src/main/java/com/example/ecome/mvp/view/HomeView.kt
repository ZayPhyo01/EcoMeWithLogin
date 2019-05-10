package com.example.ecome.mvp.view

import com.example.ecome.data.vos.CategoryVO
import com.example.ecome.data.vos.FavouriteVO
import com.example.ecome.data.vos.ProductVO

interface HomeView {

    fun showCategoryList(categoryList: MutableList<CategoryVO>)
    fun showProductList(productList : MutableList<ProductVO>)
    fun nevigateTo(id : Int)


}