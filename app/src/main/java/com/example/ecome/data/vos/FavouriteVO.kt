package com.example.ecome.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "fav_table")
data class FavouriteVO (

@PrimaryKey
@ColumnInfo
val favProductId : Int


)