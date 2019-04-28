package com.example.ecome.network

import com.example.ecome.data.vos.CategoryVO
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.delegate.BaseDelegate
import com.example.ecome.network.response.CategoryResponse
import com.example.ecome.network.response.LoginResponse
import com.example.ecome.network.response.ProductResponse
import com.example.ecome.network.response.RegisterResponse

interface DataAgent {
    fun loadCategory(categoryDelegate: BaseDelegate<CategoryResponse>)
    fun loadProduct(productDelegate: BaseDelegate<ProductResponse>)
    fun login(phone : String , pw : String , loginDelegate: BaseDelegate<LoginResponse>)
    fun register(name : String ,phone : String ,password : String , birth : String, country : String ,egisterDelegate : BaseDelegate<RegisterResponse>)
}