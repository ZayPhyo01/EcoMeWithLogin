package com.example.ecome.network

import com.example.ecome.delegate.BaseDelegate
import com.example.ecome.network.response.BaseResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


open class ProductCallback<T : BaseResponse>(delegate : BaseDelegate<T>)  : Callback<T> {

    var delegate : BaseDelegate<T>?=null



    init {
        this.delegate = delegate
    }


    override fun onFailure(call: Call<T>, t: Throwable) {
            this.delegate!!.fail("No network connection")
       }

       override fun onResponse(call: Call<T>, response: Response<T>) {
           this.delegate!!.success(response.body()!!)
       }


}