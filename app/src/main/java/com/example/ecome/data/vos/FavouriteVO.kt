package com.example.ecome.data.vos

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "fav_table")
data class FavouriteVO (

@PrimaryKey
@ColumnInfo
val favProductId : Int

)