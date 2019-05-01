package com.example.ecome.data.vos

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "category")
data class CategoryVO(

    @PrimaryKey
    @ColumnInfo(name = "category_id")
    val category_id: Int,

    @ColumnInfo(name = "category_name")
    val category_name: String,

    @ColumnInfo(name = "category_icon")
    val category_icon: String,

    @ColumnInfo(name = "category_color")
    val category_color: String
)