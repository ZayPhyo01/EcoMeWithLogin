package com.example.ecome.network.response

import com.example.ecome.data.vos.ProductVO

class ProductResponse : BaseResponse() {
    var products : MutableList<ProductVO>?=null
}