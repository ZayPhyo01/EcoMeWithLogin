package com.example.ecome.network.response

import com.example.ecome.data.vos.ProductVO

class ProductResponse : BaseResponse() {
    lateinit var products : MutableList<ProductVO>
}