package com.example.ecome.delegate

interface BaseDelegate<D> {
    fun fail(message : String)
    fun success(dataVo : D)
}