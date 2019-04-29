package com.example.ecome.data.vos

import android.arch.persistence.room.*

@Entity(
    tableName = "product_images",
    foreignKeys = [
        ForeignKey(
            entity = ProductVO::class,
            parentColumns = ["product_id"],
            childColumns = ["product_id"]
        )
    ]

)
data class ProductImageVO(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    val pkForImae :Int,

    @ColumnInfo
    val id: Int ,

    @ColumnInfo
    var image_url: String ,

    @ColumnInfo(name = "product_id")
    var product_id: Int
)