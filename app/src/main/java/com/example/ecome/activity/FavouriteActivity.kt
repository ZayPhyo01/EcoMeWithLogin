package com.example.ecome.activity

import android.os.Bundle
import com.example.ecome.R
import com.example.ecome.data.model.ProductModel

class FavouriteActivity : BaseActivity() {

    var favProduct : ProductModel

    init {
        favProduct = ProductModel.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite)
        var favProducts =  favProduct.getFavouriteProducts()
    }

}