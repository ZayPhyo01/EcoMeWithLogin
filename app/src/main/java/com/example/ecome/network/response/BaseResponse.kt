package com.example.ecome.network.response

abstract class BaseResponse {
    val code: Int? = null
    val message: String? = null
    val apiVersion: String? = null
    val page: Int? = null
}


