package com.example.ecome.persistance.typeconveter

import android.arch.persistence.room.TypeConverter
import com.example.ecome.data.vos.ProductImageVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken



class ImageTypeConveter {

    @TypeConverter
    fun toString(obj : MutableList<ProductImageVO>) : String  {

        val gson = Gson()
        return gson.toJson(obj)
    }

    @TypeConverter
    fun fromString(string : String) : MutableList<ProductImageVO> {
        val gson = Gson()
        val type = object : TypeToken<MutableList<ProductImageVO>>() {

        }.type
        return gson.fromJson(string, type)
    }

}