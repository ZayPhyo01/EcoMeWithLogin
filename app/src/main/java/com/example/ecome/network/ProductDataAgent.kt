package com.example.ecome.network

import com.example.ecome.data.vos.CategoryVO
import com.example.ecome.data.vos.ProductVO
import com.example.ecome.delegate.BaseDelegate
import com.example.ecome.network.response.CategoryResponse
import com.example.ecome.network.response.LoginResponse
import com.example.ecome.network.response.ProductResponse
import com.example.ecome.network.response.RegisterResponse
import com.example.ecome.util.DataAgentUtil
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductDataAgent private constructor() : DataAgent {
    override fun login(phone: String, pw: String, loginDelegate: BaseDelegate<LoginResponse>) {
        mEcoApi.login(phone,pw).enqueue(ProductCallback<LoginResponse>(loginDelegate))
    }

    override fun register(
        name: String,
        phone: String,
        password: String,
        birth: String,
        country: String,
        egisterDelegate: BaseDelegate<RegisterResponse>
    ) {

    }


    override fun loadCategory(categoryDelegate: BaseDelegate<CategoryResponse>) {
        var categories = mEcoApi.getCategory(DataAgentUtil.ACCESS_TOKEN, 1)
        categories.enqueue(ProductCallback<CategoryResponse>(categoryDelegate))
    }

    override fun loadProduct(productDelegate: BaseDelegate<ProductResponse>) {
        var products = mEcoApi.getProduct(DataAgentUtil.ACCESS_TOKEN, 1)
        products.enqueue(ProductCallback<ProductResponse>(productDelegate))
    }

    var mRetrofit: Retrofit? = null
    private var mEcoApi: EcoApi

    init {
        mRetrofit = Retrofit.Builder()
            .baseUrl(DataAgentUtil.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        mEcoApi = mRetrofit!!.create(EcoApi::class.java)

    }

    companion object {
        var dataAgent: ProductDataAgent? = null

        fun getInstance(): ProductDataAgent {

            if (dataAgent == null) {
                dataAgent = ProductDataAgent()
            }

            return dataAgent!!
        }
    }


}