package com.example.ecome.data.vos

import android.arch.persistence.room.*
import android.support.annotation.ColorInt
import com.example.ecome.persistance.typeconveter.ImageTypeConveter

@Entity(tableName = "product")

data class ProductVO(

    @PrimaryKey
    @ColumnInfo
    var product_id: Int = 0,

    @ColumnInfo
    var product_name: String = "",

    @TypeConverters
    @ColumnInfo
    var product_image_url: MutableList<ProductImageVO> = ArrayList(),

    @ColumnInfo
    var product_desc: String = "",

    @ColumnInfo
    var product_price: String = "",

    @ColumnInfo
    var uploaded_time: String = "",

    @ColumnInfo
    var availability: Boolean = false,

    @ColumnInfo
    var uploaded_date: String = "",

    @ColumnInfo
    var history_count : Int = 0,


    @Ignore
    var isFavourite : Boolean = false

)