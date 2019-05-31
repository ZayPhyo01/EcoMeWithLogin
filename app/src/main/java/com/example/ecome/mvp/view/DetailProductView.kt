package com.example.ecome.mvp.view

import com.example.ecome.data.vos.ProductVO

interface DetailProductView  : BaseView{
    fun showDetailProduct(productVO: ProductVO)
}